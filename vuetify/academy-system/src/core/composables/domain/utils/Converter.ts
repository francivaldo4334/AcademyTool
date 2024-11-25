import User from "@/composables/data/models/User";
import StudentModel from "../models/StudentModel";
import Registration from "@/composables/data/models/Registration";
import Modality from "@/composables/data/models/Modality";
import ModalityModel, { PaymentModality } from "../models/ModalityModel";
import { fileToBase64 } from "./Decoder";
export const ModalityModelToDomain = (m: Modality) => {
	return new ModalityModel({
		id: m.id,
		value: m.value,
		modalityPayment: m.modalityPayment as PaymentModality,
		description: m.description,
		active: m.active,
		createAt: m.createAt,
		title: m.title,
	});
};
export const ModalityDomainToModel = (m: ModalityModel) => {
	return new Modality({
		value: m.value,
		modalityPayment: m.modalityPayment,
		description: m.description,
		active: m.active,
		createAt: m.createAt,
		title: m.title,
	});
};
export const StudentModelToDomain = async (
	m: User,
	r: Registration,
	mt: Modality,
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
		modality: mt.id,
		observation: r.observation,
	});
};
export const StudentDomainToRegisterModel = (
	m: StudentModel,
	u: User,
	modality: Modality,
) => {
	return new Registration({
		active: true,
		student: u.id,
		startDate: m.startDate,
		endDate: m.endDate,
		isMonthlyPlan: m.isMonthlyPlan,
		modality: modality.id,
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
