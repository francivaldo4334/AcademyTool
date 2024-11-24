import IDatabaseAdapter from "@/composables/data/interfaces/IDatabaseAdapter";
import IModel from "@/composables/data/interfaces/IModel";
import IRepository from "./IRepository";
import Users from "@/composables/data/tables/Users";
import StudentModel from "../models/StudentModel";
import {
	StudentDomainToModel,
	StudentDomainToRegisterModel,
	StudentModelToDomain,
} from "../utils/Converter";
import Registrations from "@/composables/data/tables/Registrations";
import Modalities from "@/composables/data/tables/Modalities";

export default class implements IRepository<StudentModel> {
	users: Users;
	registrations: Registrations;
	modalities: Modalities;
	constructor(db: IDatabaseAdapter<IModel>) {
		this.users = db.getInstance(Users);
		this.registrations = db.getInstance(Registrations);
		this.modalities = db.getInstance(Modalities);
	}
	add(m: StudentModel, onResponse: (it: StudentModel) => void): void {
		if (!m.birthday) throw new Error("requred-field");
		const newUser = StudentDomainToModel(m);
		// this.modalities.getItemById(m.modality).then((modality) => {
		const modality = undefined;
		this.users.create(newUser).then((user) => {
			const newRegister = StudentDomainToRegisterModel(m, user, modality);
			this.registrations.create(newRegister).then((register) => {
				onResponse(StudentModelToDomain(user, register, modality));
			});
		});
		// });
	}
	geAll(onResponse: (it: StudentModel[]) => void): void {
		this.registrations.get().then(async (registers) => {
			const studentsRespose: StudentModel[] = [];
			for (let i = 0; i < registers.length; i++) {
				const register = registers[i];
				const user = await this.users.getItemById(register.student);
				// const modality = await this.modalities.getItemById(register.modality);
				const modality = undefined;
				studentsRespose.push(StudentModelToDomain(user, register, modality));
			}
			onResponse(studentsRespose);
		});
	}
	getById(id: number, onResponse: (it: StudentModel) => void): void {
		this.registrations.getItemById(id).then(async (register) => {
			const user = await this.users.getItemById(register.student);
			// const modality = await this.modalities.getItemById(register.modality);
			const modality = undefined;
			onResponse(StudentModelToDomain(user, register, modality));
		});
	}
}
