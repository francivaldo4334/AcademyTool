import localforage from "localforage"

export default class PkManager {
  static async getNextId(tableName: string) {
    const indexNameCounter = `${tableName}_id_counter`
    const currentId: number = (await localforage.getItem(indexNameCounter)) || 0;
    const newId = currentId + 1;
    await localforage.setItem(indexNameCounter, newId)
    return newId;
  }
}
