import Users from './tables/Users';

export class Database {
  readonly users: Users;
  readonly DB_NAME = "academySystem"
  readonly DB_VERSION = 1;
  db: IDBDatabase | undefined;
  constructor() {
    this.users = new Users(this)
    if (window.indexedDB) {
      const request = window.indexedDB.open(this.DB_NAME, this.DB_VERSION)
      request.onsuccess = () => {
        console.info("initialized indexedDB")
      }
      request.onerror = (err) => {
        console.error(err)
      }
      request.onupgradeneeded = (event) => {
        this.db = (event.target as IDBOpenDBRequest).result;
        this.db.createObjectStore(this.users.tableName, { keyPath: "id" })
      }
    }
    else {
      console.error("no support indexedDB")
    }
  }
}
