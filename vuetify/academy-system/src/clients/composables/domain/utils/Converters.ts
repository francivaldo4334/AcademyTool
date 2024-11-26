import User from "@/core/composables/data/models/User";
import Registration from "../../data/models/Registration";
import StudentModel from "../models/StudentModel";
import { fileToBase64 } from "@/core/composables/domain/utils/Decoder";

export const StudentModelToDomain = async (
  m: User,
  r: Registration,
) => {
  return new StudentModel({
    createAt: m.createAt,
    active: m.active,
    firstName: m.firstName,
    lastName: m.lastName,
    avatar: m.photo,
    cpf: m.cpf,
    birthday: m.dateOfBirth,
    gender: m.gender,
    mail: m.email,
    phone: m.phone1,
    whatsapp: m.whatsapp,
    usePhone: false,
    addressString: m.addressString,
    city: m.city,
    neighborhood: m.neighborhood,
    street: m.street,
    zipCode: m.zipCode,
    addressNumber: m.addressNumber,
    reference: m.reference,
    startDate: r.startDate,
    endDate: r.endDate,
    modality: r.modality,
    observation: r.observation,
  });
};
export const StudentDomainToRegisterModel = (
  m: StudentModel,
  u: User,
) => {
  return new Registration({
    active: true,
    student: u.id,
    startDate: m.startDate,
    endDate: m.endDate,
    isMonthlyPlan: m.isMonthlyPlan,
    modality: m.modality,
    observation: m.observation,
    status: "debited",
    createAt: new Date(),
  });
};
export const StudentDomainToModel = async (m: StudentModel) => {
  return new User({
    cpf: m.cpf,
    active: m.active || true,
    firstName: m.firstName,
    lastName: m.lastName,
    email: m.mail,
    dateOfBirth: m.birthday!,
    gender: m.gender,
    phone1: m.phone,
    phone2: "",
    whatsapp: m.whatsapp,
    photo: m.avatar instanceof File ? await fileToBase64(m.avatar) : m.avatar,
    addressString: m.addressString,
    neighborhood: m.neighborhood,
    zipCode: m.zipCode,
    city: m.city,
    hash: "",
    createAt: m.createAt || new Date(),
    street: m.street,
    addressNumber: m.addressNumber,
    reference: m.reference,
  });
};
