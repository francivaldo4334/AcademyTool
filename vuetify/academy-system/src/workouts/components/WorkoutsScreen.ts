import { z } from "zod";

export const formModalityScheme = z.object({
  title: z.string().min(5),
  value: z.string().transform(it => parseInt(it.replace(/\D/g, '') || "0")),
  description: z.string().default(""),
  modalityPayment: z.enum(["unique-payment", "monthly", "weekly", "biweekly"]),
  active: z.boolean().default(true),
})
