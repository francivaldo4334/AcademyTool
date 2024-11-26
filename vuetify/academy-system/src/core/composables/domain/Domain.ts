import IDatabaseAdapter from "../data/interfaces/IDatabaseAdapter";

export default class {
	db: IDatabaseAdapter;
	constructor(db: IDatabaseAdapter) {
		this.db = db;
	}
}
