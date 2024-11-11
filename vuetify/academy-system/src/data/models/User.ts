import IModel from "../interfaces/IModel";

export default class User implements IModel {
  id!: string;
  cpf: string;
  active: boolean;
  firstName: string;
  lastName: string;
  email: string;
  // registrationDate: DateTime;
  dateOfBirth: Date;
  gender: string;
  phone1: string;
  phone2: string;
  whatsapp: string;
  photo: string;
  addressString: string;
  neighborhood: string;
  zipCode: string;
  city: string;
  // lastLogin: DateTime;
  hash: string;
  constructor(
    data: {
      cpf: string,
      active: boolean,
      firstName: string,
      lastName: string,
      email: string,
      // registrationDate: DateTime,
      dateOfBirth: Date,
      gender: string,
      phone1: string,
      phone2: string,
      whatsapp: string,
      photo: string,
      addressString: string,
      neighborhood: string,
      zipCode: string,
      city: string,
      // lastLogin: DateTime,
      hash: string,
    }
  ) {
    this.cpf = data.cpf;
    this.active = data.active;
    this.firstName = data.firstName;
    this.lastName = data.lastName;
    this.email = data.email;
    // this.registrationDate = data.registrationDate;
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
    // this.lastLogin = data.lastLogin;
    this.hash = data.hash;
  }
}
