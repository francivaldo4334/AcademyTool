export function fileToBase64(file: File): Promise<string> {
	return new Promise((resolve, reject) => {
		const render = new FileReader();
		render.onload = () => resolve(render.result as string);
		render.onerror = (e) => reject(e);
		render.readAsDataURL(file);
	});
}
export async function base64toFile(
	base64: string,
	fileName: string,
): Promise<File> {
	const response = await fetch(base64);
	const blob = await response.blob();
	return new File([blob], fileName, { type: blob.type });
}
