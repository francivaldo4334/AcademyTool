import { Database } from "../Database";
import ITable from "../interfaces/ITable";
import User from "../models/User";

export default class Users extends ITable<User> {
  constructor(db: Database) {
    super(db, "users");
  }
}
