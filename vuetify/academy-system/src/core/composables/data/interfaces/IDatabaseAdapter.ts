import IModel from "./IModel";
import { BaseTable } from "./ITable";

export type Constructor<T> = { new(...args: any[]): T };

export default interface IDatabaseAdapter<M extends IModel = IModel> {
	get(tableName: string): Promise<M[]>;
	getItemById(tableName: string, id: string): Promise<M>;
	filter(tableName: string, params: any): Promise<M[]>;
	create(tableName: string, model: M): Promise<M>;
	delete(tableName: string, pk: string): void;
	update(tableName: string, model: M, pk: string): Promise<M>;
	getInstance<T extends BaseTable<M>>(type: Constructor<T>): T;
}
