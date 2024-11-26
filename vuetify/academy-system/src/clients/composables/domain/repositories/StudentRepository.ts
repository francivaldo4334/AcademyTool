import IDatabaseAdapter from "@/core/composables/data/interfaces/IDatabaseAdapter";
import IModel from "@/core/composables/data/interfaces/IModel";
import IRepository from "@/core/composables/domain/repositories/IRepository";
import Users from "@/core/composables/data/tables/Users";
import {
	StudentDomainToModel,
	StudentDomainToRegisterModel,
	StudentModelToDomain,
} from "../utils/Converters";
import Registrations from "../../data/tables/Registrations";
import StudentModel from "../models/StudentModel";

export default class implements IRepository<StudentModel> {
	users: Users;
	registrations: Registrations;
	constructor(db: IDatabaseAdapter<IModel>) {
		this.users = db.getInstance(Users);
		this.registrations = db.getInstance(Registrations);
	}
	async add(m: StudentModel, onResponse: (it: StudentModel) => void) {
		if (!m.birthday) throw new Error("requred-field");
		const newUser = await StudentDomainToModel(m);
		this.users.create(newUser).then((user) => {
			const newRegister = StudentDomainToRegisterModel(m, user);
			this.registrations.create(newRegister).then(async (register) => {
				onResponse(await StudentModelToDomain(user, register));
			});
		});
	}
	getAll(onResponse: (it: StudentModel[]) => void): void {
		this.registrations.get().then(async (registers) => {
			const studentsRespose: StudentModel[] = [];
			for (let i = 0; i < registers.length; i++) {
				const register = registers[i];
				const user = await this.users.getItemById(register.student);
				studentsRespose.push(
					await StudentModelToDomain(user, register),
				);
			}
			onResponse(studentsRespose);
		});
	}
	getById(id: string, onResponse: (it: StudentModel) => void): void {
		this.registrations.getItemById(id).then(async (register) => {
			const user = await this.users.getItemById(register.student);
			onResponse(await StudentModelToDomain(user, register));
		});
	}
}
