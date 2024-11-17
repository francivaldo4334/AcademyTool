import IModelDomain from "./IModelDomain";

export default class implements IModelDomain {
  id?: number
  firstName: string;
  lastName: string;
  cpf: string;
  dateOfBirth: Date;
  active: boolean;
  email: string;
  gender: string;
  phone: string;
  whatsapp: string;
  photo: string;
  addressString: string;
  neighborhood: string;
  zipCode: string;
  city: string;
  constructor(
    data: {
      cpf: string,
      active: boolean,
      firstName: string,
      lastName: string,
      email: string,
      dateOfBirth: Date,
      gender: string,
      phone: string,
      whatsapp: string,
      photo: string,
      addressString: string,
      neighborhood: string,
      zipCode: string,
      city: string,
    }
  ) {
    this.cpf = data.cpf;
    this.active = data.active;
    this.firstName = data.firstName;
    this.lastName = data.lastName;
    this.email = data.email;
    this.dateOfBirth = data.dateOfBirth;
    this.gender = data.gender;
    this.phone = data.phone;
    this.whatsapp = data.whatsapp;
    this.photo = data.photo;
    this.addressString = data.addressString;
    this.neighborhood = data.neighborhood;
    this.zipCode = data.zipCode;
    this.city = data.city;
  }
}
