import User from "@/composables/data/models/User";
import StudentModel from "../models/StudentModel";

export const StudentModelToDomain = (m: User) => {
  return new StudentModel({
    cpf: m.cpf,
    active: m.active,
    firstName: m.firstName,
    lastName: m.lastName,
    email: m.email,
    dateOfBirth: m.dateOfBirth,
    gender: m.gender,
    phone: m.phone1,
    whatsapp: m.whatsapp,
    photo: m.photo,
    addressString: m.addressString,
    neighborhood: m.neighborhood,
    zipCode: m.zipCode,
    city: m.city,
  })
}
export const StudentDomainToModel = (m: StudentModel) => {
  return new User({
    cpf: m.cpf,
    active: m.active,
    firstName: m.firstName,
    lastName: m.lastName,
    email: m.email,
    dateOfBirth: m.dateOfBirth,
    gender: m.gender,
    phone1: m.phone,
    phone2: "",
    whatsapp: m.whatsapp,
    photo: m.photo,
    addressString: m.addressString,
    neighborhood: m.neighborhood,
    zipCode: m.zipCode,
    city: m.city,
    hash: ""
  })
}
