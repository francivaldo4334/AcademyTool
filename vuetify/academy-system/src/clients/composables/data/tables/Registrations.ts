import IDatabaseAdapter from "@/core/composables/data/interfaces/IDatabaseAdapter";
import IModel from "@/core/composables/data/interfaces/IModel";
import { BaseTable } from "@/core/composables/data/interfaces/ITable";
import Registration from "../models/Registration";

export default class Registrations extends BaseTable<Registration> {
	constructor(db: IDatabaseAdapter<IModel>) {
		super(db, "registrations");
	}
}
