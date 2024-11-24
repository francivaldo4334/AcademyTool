import IModel from "../interfaces/IModel";

export default class User implements IModel {
	id!: string;
	createAt: Date;
	cpf: string;
	active: boolean;
	firstName: string;
	lastName: string;
	email: string;
	dateOfBirth: Date;
	gender: string;
	phone1: string;
	phone2: string;
	whatsapp: string;
	photo: string | undefined;
	addressString: string;
	neighborhood: string;
	zipCode: string;
	city: string;
	street: string;
	addressNumber: string;
	reference: string;
	lastLogin: Date | undefined;
	registrationDate: Date | undefined;
	hash: string;
	constructor(data: {
		cpf: string;
		active: boolean;
		firstName: string;
		lastName: string;
		email: string;
		dateOfBirth: Date;
		gender: string;
		phone1: string;
		phone2: string;
		whatsapp: string;
		photo?: string;
		addressString: string;
		neighborhood: string;
		zipCode: string;
		city: string;
		hash: string;
		createAt: Date;
		street: string;
		addressNumber: string;
		reference: string;
	}) {
		this.createAt = data.createAt;
		this.cpf = data.cpf;
		this.active = data.active;
		this.firstName = data.firstName;
		this.lastName = data.lastName;
		this.email = data.email;
		this.registrationDate = new Date();
		this.dateOfBirth = data.dateOfBirth;
		this.gender = data.gender;
		this.phone1 = data.phone1;
		this.phone2 = data.phone2;
		this.whatsapp = data.whatsapp;
		this.photo = data.photo;
		this.addressString = data.addressString;
		this.neighborhood = data.neighborhood;
		this.zipCode = data.zipCode;
		this.city = data.city;
		this.hash = data.hash;
		this.street = data.street;
		this.addressNumber = data.addressNumber;
		this.reference = data.reference;
	}
}
