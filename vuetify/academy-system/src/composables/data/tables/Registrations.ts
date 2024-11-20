import IDatabaseAdapter from "../interfaces/IDatabaseAdapter";
import IModel from "../interfaces/IModel";
import { BaseTable } from "../interfaces/ITable";
import Registration from "../models/Registration";

export default class Registrations extends BaseTable<Registration> {
	constructor(db: IDatabaseAdapter<IModel>) {
		super(db, "registrations");
	}
}
