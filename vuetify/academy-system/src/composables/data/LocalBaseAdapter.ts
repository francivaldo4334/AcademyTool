import Localbase from 'localbase';
import IDatabaseAdapter from './interfaces/IDatabaseAdapter';
import IModel from './interfaces/IModel';
import User from './models/User';
import Users from './tables/Users';

export default class implements IDatabaseAdapter {
  readonly DB_NAME = "academySystem"
  readonly DB_VERSION = 1;
  readonly users: Users
  db: Localbase
  constructor() {
    this.db = new Localbase(this.DB_NAME)
    this.users = new Users(this)
  }
  get(tableName: string, response?: ((it: IModel[]) => void) | undefined): void {
    this.db
      .collection(tableName)
      .get()
      .then((it: IModel[]) => {
        if (response) {
          response(it)
        }
      })
  }
  filter(tableName: string, params: any, response?: ((it: IModel[]) => void) | undefined): void {
    this.db.collection(tableName)
      .doc(params)
      .then((it: IModel[]) => {
        if (response) {
          response(it)
        }
      })
  }
  getItemById(tableName: string, id: number, response?: ((it: IModel) => void) | undefined): void {
    this.db.collection(tableName)
      .doc({ id: id })
      .get()
      .then((it: IModel) => {
        if (response) {
          response(it)
        }
      })
  }
  create(tableName: string, model: IModel, response?: ((it: IModel) => void) | undefined): void {
    this.db.collection(tableName)
      .add(model)
  }
  delete(tableName: string, pk: number): void {
    this.db.collection(tableName)
      .doc({ id: pk })
      .delete();
  }
  update(tableName: string, model: IModel, pk: number, response?: ((it: IModel) => void) | undefined): void {
    this.db.collection(tableName)
      .doc({ id: pk })
      .update(model)
  }
}
