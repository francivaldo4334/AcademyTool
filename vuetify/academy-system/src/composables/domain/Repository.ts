import { Database } from "../data/Database";

export default class {
  readonly db: Database;
  constructor(db: Database) {
    this.db = db;
  }
}
