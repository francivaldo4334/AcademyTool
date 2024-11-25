import IModelDomain from "./IModelDomain";
export type PaymentModality =
	| "unique-payment"
	| "monthly"
	| "weekly"
	| "biweekly";
export default class implements IModelDomain {
	id?: string;
	value: number;
	description: string;
	modalityPayment: PaymentModality;
	active: boolean;
	createAt?: Date;
	title: string;
	constructor(data: {
		id?: string;
		value: number;
		description: string;
		modalityPayment: PaymentModality;
		active: boolean;
		createAt?: Date;
		title: string;
	}) {
		this.id = data.id;
		this.value = data.value;
		this.description = data.description;
		this.modalityPayment = data.modalityPayment;
		this.active = data.active;
		this.createAt = data.createAt;
		this.title = data.title;
	}
}
