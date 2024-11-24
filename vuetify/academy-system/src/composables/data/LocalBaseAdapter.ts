import Localbase from "localbase";
import IDatabaseAdapter, { Constructor } from "./interfaces/IDatabaseAdapter";
import IModel from "./interfaces/IModel";
import Users from "./tables/Users";
import ITable from "./interfaces/ITable";
import Modalities from "./tables/Modalities";
import Registrations from "./tables/Registrations";
import { v4 as useUuid } from "uuid";

export default class implements IDatabaseAdapter {
	readonly DB_NAME = "academySystem";
	readonly DB_VERSION = 1;
	readonly users: Users;
	readonly modalities: Modalities;
	readonly registrations: Registrations;
	db: Localbase;
	constructor() {
		this.db = new Localbase(this.DB_NAME);
		this.users = new Users(this);
		this.modalities = new Modalities(this);
		this.registrations = new Registrations(this);
	}
	getInstance<T extends ITable<IModel>>(type: Constructor<T>): T {
		if (this.users instanceof type) {
			return this.users;
		}
		if (this.registrations instanceof type) {
			return this.registrations;
		}
		if (this.modalities instanceof type) {
			return this.modalities;
		}
		throw new Error("Method not implemented.");
	}
	get(tableName: string): Promise<IModel[]> {
		return this.db.collection(tableName).get();
	}
	filter(tableName: string, params: any): Promise<IModel[]> {
		return this.db.collection(tableName).doc(params);
	}
	getItemById(tableName: string, id: string): Promise<IModel> {
		return this.db.collection(tableName).doc(id).get();
	}
	async create(tableName: string, model: IModel): Promise<IModel> {
		model.id = useUuid();
		const respose = await this.db.collection(tableName).add(model, model.id);
		return respose.data.data;
	}
	delete(tableName: string, pk: string): void {
		this.db.collection(tableName).doc({ id: pk }).delete();
	}
	update(tableName: string, model: IModel, pk: string): Promise<IModel> {
		return this.db.collection(tableName).doc({ id: pk }).update(model);
	}
}
