import PkManager from "../utils/PkManager";
import IModel from "./IModel";
import localforage from "localforage"

export default abstract class ITable<M extends IModel> {
  tableName: string;
  constructor(tableName: string) {
    this.tableName = tableName;
  }
  async getAll() {
    const models = (await localforage.getItem(this.tableName) || []) as M[];
    return models;
  }
  async getById(pk: number) {
    const models = await this.getAll();
    return models.find(it => it.pk === pk);
  }
  async add(model: M) {
    const models = await this.getAll();
    model.pk = await PkManager.getNextId(this.tableName);
    models.push(model);
    await localforage.setItem(this.tableName, models)
    return model
  }
  async remove(pk: number) {
    const models = await this.getAll();
    const updatedModels = models.filter(it => it.pk !== pk);
    await localforage.setItem(this.tableName, updatedModels);
  }
  async update(model: M) {
    const models = await this.getAll();
    const updatedModels = models.map(it => {
      if (it.pk === model.pk) {
        return models
      }
      return it
    })
    await localforage.setItem(this.tableName, updatedModels);
  }
}
