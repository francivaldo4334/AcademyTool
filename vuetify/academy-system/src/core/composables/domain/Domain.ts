import IDatabaseAdapter, { Constructor } from "../data/interfaces/IDatabaseAdapter";
import IModelDomain from "./models/IModelDomain";
import IRepository from "./repositories/IRepository";

export default class {
	db: IDatabaseAdapter;
	private repositories: IRepository<IModelDomain>[] = []
	constructor(db: IDatabaseAdapter) {
		this.db = db;
	}
	getRepository<T extends IRepository<IModelDomain>>(classRepository: Constructor<T>): T {
		let returnRepository: IRepository<IModelDomain> | null = null
		for (const repository of this.repositories) {
			if (repository instanceof classRepository) {
				returnRepository = repository
				break;
			}
		}
		if (!returnRepository) {
			returnRepository = new classRepository(this.db);
		}
		return returnRepository as T
	}
}
