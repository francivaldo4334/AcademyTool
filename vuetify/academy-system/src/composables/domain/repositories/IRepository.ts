import IDatabaseAdapter from "@/composables/data/interfaces/IDatabaseAdapter";
import IModelDomain from "../models/IModelDomain";

export default interface IRepository<M extends IModelDomain> {
  geAll(onResponse: (it: M[]) => void): void
  getById(id: number, onResponse: (it: M) => void): void
  add(model: M, onResponse: (it: M) => void): void
}
