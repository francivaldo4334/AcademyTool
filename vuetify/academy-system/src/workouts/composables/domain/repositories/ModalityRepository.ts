import IRepository from "@/core/composables/domain/repositories/IRepository";
import ModalityModel from "../models/ModalityModel";
import {
	ModalityDomainToModel,
	ModalityModelToDomain,
} from "../utils/Converters";
import Modalities from "../../tables/Modalities";
import IDatabaseAdapter from "@/core/composables/data/interfaces/IDatabaseAdapter";
import IModel from "@/core/composables/data/interfaces/IModel";

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
