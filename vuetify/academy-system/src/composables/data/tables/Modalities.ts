import IDatabaseAdapter from "../interfaces/IDatabaseAdapter";
import IModel from "../interfaces/IModel";
import { BaseTable } from "../interfaces/ITable";
import Modality from "../models/Modality";

export default class Modalities extends BaseTable<Modality> {
	constructor(db: IDatabaseAdapter<IModel>) {
		super(db, "modalities");
	}
}
