import IModelDomain from "./IModelDomain";
export type PaymentModality =
	| "unique-payment"
	| "monthly"
	| "weekly"
	| "biweekly";
export default class implements IModelDomain {
	id?: number;
	value: number;
	description: string;
	modalityPayment: PaymentModality;
	active: boolean;
	constructor(data: {
		id?: number;
		value: number;
		description: string;
		modalityPayment: PaymentModality;
		active: boolean;
	}) {
		this.id = data.id;
		this.value = data.value;
		this.description = data.description;
		this.modalityPayment = data.modalityPayment;
		this.active = data.active;
	}
}
