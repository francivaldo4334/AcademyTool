import IDatabaseAdapter from "@/composables/data/interfaces/IDatabaseAdapter";
import IModelDomain from "../models/IModelDomain";

export default interface IRepository<M extends IModelDomain> {
	getAll(onResponse: (it: M[]) => void): void;
	getById(id: string, onResponse: (it: M) => void): void;
	add(model: M, onResponse: (it: M) => void): void;
}
