import IDatabaseAdapter from "@/composables/data/interfaces/IDatabaseAdapter";
import ModalityModel from "../models/ModalityModel";
import IRepository from "./IRepository";
import IModel from "@/composables/data/interfaces/IModel";
import Modalities from "@/composables/data/tables/Modalities";
import {
	ModalityDomainToModel,
	ModalityModelToDomain,
} from "../utils/Converter";

export default class implements IRepository<ModalityModel> {
	modalities: Modalities;
	constructor(db: IDatabaseAdapter<IModel>) {
		this.modalities = db.getInstance(Modalities);
	}
	getAll(onResponse: (it: ModalityModel[]) => void): void {
		this.modalities.get().then((modalities) => {
			onResponse(modalities.map((it) => ModalityModelToDomain(it)));
		});
	}
	getById(id: string, onResponse: (it: ModalityModel) => void): void {
		throw new Error("Method not implemented.");
	}
	add(model: ModalityModel, onResponse: (it: ModalityModel) => void): void {
		this.modalities.create(ModalityDomainToModel(model)).then((modality) => {
			onResponse(ModalityModelToDomain(modality));
		});
	}
}
