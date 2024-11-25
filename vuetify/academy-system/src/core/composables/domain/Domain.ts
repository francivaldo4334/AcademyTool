import IDatabaseAdapter from "../data/interfaces/IDatabaseAdapter";
import Users from "../data/tables/Users";
import ModalityRepository from "./repositories/ModalityRepository";
import StudentRepository from "./repositories/StudentRepository";

export default class {
	db: IDatabaseAdapter;
	users: StudentRepository;
	modalities: ModalityRepository;
	constructor(db: IDatabaseAdapter) {
		this.db = db;
		this.users = new StudentRepository(db);
		this.modalities = new ModalityRepository(db);
	}
}
