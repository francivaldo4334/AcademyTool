import IModel from "../interfaces/IModel";

export default class Modality implements IModel {
	id!: string;
	value: number;
	description: string;
	modalityPayment: string;
	active: boolean;
	constructor(data: {
		value: number;
		description: string;
		modalityPayment: string;
		active: boolean;
	}) {
		this.value = data.value;
		this.description = data.description;
		this.modalityPayment = data.modalityPayment;
		this.active = data.active;
	}
}
