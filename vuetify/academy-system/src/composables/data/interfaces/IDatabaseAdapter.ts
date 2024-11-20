import IModel from "./IModel";
import ITable from "./ITable";

export type Constructor<T> = { new (...args: any[]): T };

export default interface IDatabaseAdapter<M extends IModel = IModel> {
	get(tableName: string): Promise<M[]>;
	getItemById(tableName: string, id: number): Promise<M>;
	filter(tableName: string, params: any): Promise<M[]>;
	create(tableName: string, model: M): Promise<M>;
	delete(tableName: string, pk: number): void;
	update(tableName: string, model: M, pk: number): Promise<M>;
	getInstance<T extends ITable<M>>(type: Constructor<T>): T;
}
