import { v4 as uuidv4 } from 'uuid'
export default class PkManager {
  static getNextId(tableName: string) {
    return `${tableName}__${uuidv4()}`;
  }
}
