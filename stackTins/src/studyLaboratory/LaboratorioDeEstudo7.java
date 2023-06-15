package studyLaboratory;

public class LaboratorioDeEstudo7 {

	public static long calculaExpoente(int val, int exp) {

		if (exp == 0) {
			return 1;
		}

		return val * calculaExpoente(val, exp - 1);

	}

	public static int buscaBinaria(int[] arr, int inicio, int fim, int chave) {
		if (fim >= inicio) {
			int meio = inicio + (fim - inicio) / 2;
			if (arr[meio] == chave) {
				return meio;
			}
			if (arr[meio] > chave) {
				return buscaBinaria(arr, inicio, meio - 1, chave);
			} else {
				return buscaBinaria(arr, meio + 1, fim, chave);
			}
		}
		return -1;
	}

	public static void contagemRegressiva(int posicao) {

		if (posicao == 0) {
			System.out.println("Decolar!");
		} else {
			System.out.println(posicao);
			contagemRegressiva(posicao - 1);
		}

	}

	public static void main(String[] args) {

		System.out.println("*********Busca binaria*********");
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(buscaBinaria(arr, 0, 10, 5));

		System.out.println("*********Contagem regressiva*********");
		contagemRegressiva(10);

		System.out.println("*********Calcula expoente*********");
		System.out.println(calculaExpoente(3, 2));

	}

}
