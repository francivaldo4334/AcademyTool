import ITable from "../interfaces/ITable";
import User from "../models/User";

export default class Users extends ITable<User> {
  constructor() {
    super("users");
  }
}
