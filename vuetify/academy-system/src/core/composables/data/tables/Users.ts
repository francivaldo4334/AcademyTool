import IDatabaseAdapter from "../interfaces/IDatabaseAdapter";
import IModel from "../interfaces/IModel";
import { BaseTable } from "../interfaces/ITable";
import User from "../models/User";

export default class Users extends BaseTable<User> {
	constructor(db: IDatabaseAdapter<IModel>) {
		super(db, "users");
	}
}
