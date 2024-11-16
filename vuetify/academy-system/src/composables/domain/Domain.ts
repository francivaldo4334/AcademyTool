import IDatabaseAdapter from "../data/interfaces/IDatabaseAdapter";
import Users from "../data/tables/Users";
import StudentRepository from "./repositories/StudentRepository";

export default class {
  db: IDatabaseAdapter
  users: StudentRepository
  constructor(db: IDatabaseAdapter) {
    this.db = db
    this.users = new StudentRepository(db)
  }
}
