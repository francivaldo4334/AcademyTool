import IModel from "./IModel"

export default interface IDatabaseAdapter<M extends IModel = IModel> {
  get(tableName: string, response: (it: M[]) => void): void
  getItemById(tableName: string, id: number, response: (it: M) => void): void
  filter(tableName: string, params: any, response: (it: M[]) => void): void
  create(tableName: string, model: M, response: (it: M) => void): void
  delete(tableName: string, pk: number): void
  update(tableName: string, model: M, pk: number, response: (it: M) => void): void
}
