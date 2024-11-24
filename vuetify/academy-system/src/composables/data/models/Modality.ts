import { date } from "zod";
import IModel from "../interfaces/IModel";

export default class Modality implements IModel {
	id!: string;
	value: number;
	description: string;
	modalityPayment: string;
	active: boolean;
	createAt: Date;
	title: string;
	constructor(data: {
		value: number;
		description: string;
		modalityPayment: string;
		active: boolean;
		title: string;
		createAt?: Date;
	}) {
		this.value = data.value;
		this.description = data.description;
		this.modalityPayment = data.modalityPayment;
		this.active = data.active;
		this.createAt = data.createAt || new Date();
		this.title = data.title;
	}
}
