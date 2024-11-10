import localforage from 'localforage';
import Users from './tables/Users';
import { App } from 'vue';

export class Database {
  readonly users: Users;
  constructor() {
    localforage.config({
      name: "academySystem",
      storeName: "academySystemDb"
    })
    this.users = new Users()
  }
}
