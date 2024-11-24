import IModelDomain from "./IModelDomain";

export default class implements IModelDomain {
	id?: number;
	active?: boolean;
	createAt?: Date;

	firstName: string;
	lastName: string;
	avatar?: File;
	cpf: string;
	birthday?: Date;
	gender: string;
	mail: string;
	phone: string;
	whatsapp: string;
	usePhone: boolean;
	//
	addressString: string;
	city: string;
	neighborhood: string;
	street: string;
	zipCode: string;
	addressNumber: string;
	reference: string;
	//
	startDate: Date;
	endDate?: Date;
	modality?: number;
	observation: string;
	isMonthlyPlan: boolean;
	constructor(data: {
		active?: boolean;
		firstName: string;
		lastName: string;
		avatar?: File;
		cpf: string;
		birthday?: Date;
		gender: string;
		mail: string;
		phone: string;
		whatsapp: string;
		usePhone: boolean;
		addressString: string;
		city: string;
		neighborhood: string;
		street: string;
		zipCode: string;
		addressNumber: string;
		reference: string;
		startDate?: Date;
		endDate?: Date;
		modality?: number;
		observation: string;
		isMonthlyPlan?: boolean;
		createAt?: Date;
	}) {
		this.active = data.active;
		this.createAt = data.createAt;
		this.firstName = data.firstName;
		this.lastName = data.lastName;
		this.avatar = data.avatar;
		this.cpf = data.cpf;
		this.birthday = data.birthday;
		this.gender = data.gender;
		this.mail = data.mail;
		this.phone = data.phone;
		this.whatsapp = data.whatsapp;
		this.usePhone = data.usePhone;
		this.addressString = data.addressString;
		this.city = data.city;
		this.neighborhood = data.neighborhood;
		this.street = data.street;
		this.zipCode = data.zipCode;
		this.addressNumber = data.addressNumber;
		this.reference = data.reference;
		this.startDate = data.startDate || new Date();
		this.endDate = data.endDate;
		this.modality = data.modality;
		this.observation = data.observation;
		this.isMonthlyPlan = data.isMonthlyPlan || true;
	}
}
