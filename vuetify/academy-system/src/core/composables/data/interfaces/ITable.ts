import IDatabaseAdapter from "./IDatabaseAdapter";
import IModel from "./IModel";

export default interface ITable<M extends IModel> {
	tableName: string;
	db: IDatabaseAdapter<M>;
	get(response: (it: M[]) => void): void;
	getItemById(id: string): Promise<M>;
	filter(params: any): Promise<M[]>;
	create(model: M): Promise<M>;
	delete(pk: string): void;
	update(model: M, pk: string): Promise<M>;
}

export abstract class BaseTable<M extends IModel> implements ITable<M> {
	tableName: string;
	db: IDatabaseAdapter<M>;
	constructor(db: IDatabaseAdapter<IModel>, tableName: string) {
		this.db = db as IDatabaseAdapter<M>;
		this.tableName = tableName;
	}
	getItemById(id: string): Promise<M> {
		return this.db.getItemById(this.tableName, id);
	}
	filter(params: any): Promise<M[]> {
		return this.db.filter(this.tableName, params);
	}
	create(model: M): Promise<M> {
		return this.db.create(this.tableName, model);
	}
	delete(pk: string): void {
		this.db.delete(this.tableName, pk);
	}
	update(model: M, pk: string): Promise<M> {
		return this.db.update(this.tableName, model, pk);
	}
	get(): Promise<M[]> {
		return this.db.get(this.tableName);
	}
}
