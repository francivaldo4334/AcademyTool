import User from "@/composables/data/models/User";
import StudentModel from "../models/StudentModel";

export const StudentModelToDomain = (m: User) => {
	return new StudentModel({
		active: m.active,
		firstName: m.firstName,
		lastName: m.lastName,
		avatar: m.photo,
		cpf: m.cpf,
		birthday: m.dateOfBirth,
		gender: m.gender,
		mail: m.email,
		phone: "",
		whatsapp: m.whatsapp,
		usePhone: false,
		addressString: m.addressString,
		city: m.city,
		neighborhood: m.neighborhood,
		street: "",
		zipCode: m.zipCode,
		addressNumber: "",
		reference: "",
		startDate: undefined,
		endDate: undefined,
		modality: "",
		observation: "",
	});
};
export const StudentDomainToModel = (m: StudentModel) => {
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
		photo: m.avatar,
		addressString: m.addressString,
		neighborhood: m.neighborhood,
		zipCode: m.zipCode,
		city: m.city,
		hash: "",
	});
};
