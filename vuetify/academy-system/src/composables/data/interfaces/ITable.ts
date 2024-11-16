import IDatabaseAdapter from "./IDatabaseAdapter";
import IModel from "./IModel";

export default interface ITable<M extends IModel> {
  tableName: string;
  db: IDatabaseAdapter<M>;
  get(response: (it: M[]) => void): void
  getItemById(id: number, response: (it: M) => void): void
  filter(params: any, response: (it: M[]) => void): void
  create(model: M, response: (it: M) => void): void
  delete(pk: number): void
  update(model: M, pk: number, response: (it: M) => void): void
}

export abstract class BaseTable<M extends IModel> implements ITable<M> {
  tableName: string;
  db: IDatabaseAdapter<M>;
  constructor(db: IDatabaseAdapter<IModel>, tableName: string) {
    this.db = db as IDatabaseAdapter<M>;
    this.tableName = tableName;
  }
  getItemById(id: number, response: (it: M) => void): void {
    this.db.getItemById(this.tableName, id, response)
  }
  filter(params: any, response: (it: M[]) => void): void {
    this.db.filter(this.tableName, params, response)
  }
  create(model: M, response: (it: M) => void): void {
    this.db.create(this.tableName, model, response)
  }
  delete(pk: number): void {
    this.db.delete(this.tableName, pk)
  }
  update(model: M, pk: number, response: (it: M) => void): void {
    this.db.update(this.tableName, model, pk, response)
  }
  get(response: ((it: M[]) => void)): void {
    this.db.get(this.tableName, response)
  }
}
