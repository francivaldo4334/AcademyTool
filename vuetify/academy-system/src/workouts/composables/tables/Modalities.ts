import { BaseTable } from "@/core/composables/data/interfaces/ITable";
import Modality from "../data/models/Modality";
import IDatabaseAdapter from "@/core/composables/data/interfaces/IDatabaseAdapter";
import IModel from "@/core/composables/data/interfaces/IModel";

export default class Modalities extends BaseTable<Modality> {
	constructor(db: IDatabaseAdapter<IModel>) {
		super(db, "modalities");
	}
}
