import Localbase from "localbase";
import IDatabaseAdapter, { Constructor } from "./interfaces/IDatabaseAdapter";
import IModel from "./interfaces/IModel";
import { v4 as useUuid } from "uuid";
import { BaseTable } from "./interfaces/ITable";

export default class implements IDatabaseAdapter {
	readonly DB_NAME = "academySystem";
	readonly DB_VERSION = 1;
	private tableInstances: BaseTable<IModel>[] = []
	db: Localbase;
	constructor() {
		this.db = new Localbase(this.DB_NAME);
	}
	getInstance<T extends BaseTable<IModel>>(classTable: Constructor<T>): T {
		let returnInstance: T | null = null
		for (const instance of this.tableInstances) {
			if (instance instanceof classTable) {
				returnInstance = instance;
			}
		}
		if (!returnInstance) {
			returnInstance = new classTable(this);
			this.tableInstances.push(returnInstance);
		}
		return returnInstance
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
