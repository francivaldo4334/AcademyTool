import IDatabaseAdapter from "@/composables/data/interfaces/IDatabaseAdapter";
import IModel from "@/composables/data/interfaces/IModel";
import IRepository from "./IRepository";
import Users from "@/composables/data/tables/Users";
import StudentModel from "../models/StudentModel";
import { StudentDomainToModel, StudentModelToDomain } from "../utils/Converter";

export default class implements IRepository<StudentModel> {
	table: Users;
	constructor(db: IDatabaseAdapter<IModel>) {
		this.table = db.getInstance(Users);
	}
	add(m: StudentModel, onResponse: (it: StudentModel) => void): void {
		const newUser = StudentDomainToModel(m);
		newUser.active = true;
		this.table.create(newUser, (it) => {
			onResponse(StudentModelToDomain(it));
		});
	}
	geAll(onResponse: (it: StudentModel[]) => void): void {
		this.table.get((it) => {
			onResponse(it.map((it) => StudentModelToDomain(it)));
		});
	}
	getById(id: number, onResponse: (it: StudentModel) => void): void {
		this.table.getItemById(id, (it) => {
			onResponse(StudentModelToDomain(it));
		});
	}
}
