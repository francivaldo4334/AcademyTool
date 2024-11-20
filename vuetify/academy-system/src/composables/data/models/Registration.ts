import IModel from "../interfaces/IModel";
type Status = "debited" | "debitor";
export default class Registration implements IModel {
	id!: number;
	active: boolean;
	student: number;
	createAt: Date;
	startDate: Date;
	endDate?: Date;
	isMonthlyPlan: boolean;
	status: Status;
	modality: number;
	observation: string;
	constructor(data: {
		active: boolean;
		student: number;
		createAt: Date;
		startDate: Date;
		endDate?: Date;
		status: Status;
		modality: number;
		observation: string;
		isMonthlyPlan: boolean;
	}) {
		this.active = data.active;
		this.student = data.student;
		this.createAt = data.createAt;
		this.startDate = data.startDate;
		this.endDate = data.endDate;
		this.status = data.status;
		this.modality = data.modality;
		this.observation = data.observation;
		this.isMonthlyPlan = data.isMonthlyPlan;
	}
}
