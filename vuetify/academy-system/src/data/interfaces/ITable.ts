import { Database } from "../Database";
import PkManager from "../utils/PkManager";
import IModel from "./IModel";

export default abstract class ITable<M extends IModel> {
  tableName: string;
  db: IDBDatabase | undefined;
  constructor(db: Database, tableName: string) {
    this.tableName = tableName;
    this.db = db.db;
  }
  async getAll() {
    const models = localStorage.getItem(this.tableName)
    if (models) {
      return JSON.parse(models) as M[]
    }
    return []
  }
  async getById(pk: number) {
    if (!this.db) return;
    const transaction = this.db.transaction([this.tableName], 'readonly');
    const store = transaction.objectStore(this.tableName);
    return store.get(pk);
  }
  async create(model: M) {
    if (!this.db) return;
    const transaction = this.db.transaction([this.tableName], "readwrite");
    const store = transaction.objectStore(this.tableName);
    model.id = PkManager.getNextId(this.tableName)
    return store.add(model)
  }
  async remove(pk: number) {
    if (!this.db) return;
    const transaction = this.db.transaction([this.tableName], 'readwrite');
    const store = transaction.objectStore(this.tableName);
    store.delete(pk)
  }
  async update(model: M) {
    if (!this.db) return;
    const transaction = this.db.transaction([this.tableName], 'readwrite');
    const store = transaction.objectStore(this.tableName);
    store.put(model)
  }
}
