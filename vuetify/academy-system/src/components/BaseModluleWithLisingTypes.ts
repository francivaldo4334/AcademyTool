import { ZodSchema } from "zod"
export type FilterItem<M, I> = Record<keyof M, (it: I[]) => I[]>;
export const PerPageRanges = [5, 10, 15, 20];
export type FormItem = {
  scheme: ZodSchema,
  onSubmit: () => void;
}
export type MenuItem = {
  key: 0,
  name: string,
}
