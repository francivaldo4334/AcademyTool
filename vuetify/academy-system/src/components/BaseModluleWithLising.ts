import IModelDomain from "@/composables/domain/models/IModelDomain";
import IRepository from "@/composables/domain/repositories/IRepository";
import { ZodSchema } from "zod";
export type FilterItem<M, I> = Record<keyof M, (it: I[]) => I[]>;
export type MenuItem<IT extends IModelDomain> = {
	key: number;
	name: string;
	filters: Record<string, Function>;
	repository: IRepository<IT>;
	scheme: ZodSchema;
	tableScheme: ZodSchema;
};
