import Modality from "../../data/models/Modality";
import ModalityModel, { PaymentModality } from "../models/ModalityModel";

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
