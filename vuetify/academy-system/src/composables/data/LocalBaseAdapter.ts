import Localbase from 'localbase';
import IDatabaseAdapter, { Constructor } from './interfaces/IDatabaseAdapter';
import IModel from './interfaces/IModel';
import User from './models/User';
import Users from './tables/Users';
import ITable from './interfaces/ITable';


export default class implements IDatabaseAdapter {
  readonly DB_NAME = "academySystem"
  readonly DB_VERSION = 1;
  readonly users: Users
  db: Localbase
  constructor() {
    this.db = new Localbase(this.DB_NAME)
    this.users = new Users(this)
  }
  getInstance<T extends ITable<IModel>>(type: Constructor<T>): T {
    if (this.users instanceof type) {
      return this.users
    }
    throw new Error('Method not implemented.');
  }
  get(tableName: string, response?: ((it: IModel[]) => void)): void {
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
  async create(tableName: string, model: IModel, response?: ((it: IModel) => void) | undefined): Promise<void> {
    try {
      await this.db.collection(tableName).add(model);
      console.log('Document added successfully');
      if (response) {
        response(model);
      }
    } catch (error) {
      console.error('Error adding document:', error);
    }
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