package studyLaboratory;

public class LaboratorioDeEstudo6 {

	static long calculaTermoFibonacciRecursivo(int posicao) {

		if (posicao == 1 || posicao == 2) {
			return 1;
		}

		return calculaTermoFibonacciRecursivo(posicao - 1) + calculaTermoFibonacciRecursivo(posicao - 2);
	}

	static long calculaFatorialRecursivo(long numero) {

		if (numero < 0) {
			System.out.println("Volta para o ensino medio");
			throw new NullPointerException();
		}

		if (numero == 0 || numero == 1) {
			return 1;
		}

		return numero * calculaFatorialRecursivo(numero - 1);

	}

	static long calculaFatorial(long numero) {

		long resultado = 1;

		if (numero == 0 || numero == 1) {
			return resultado;
		}

		while (numero > 1) {
			resultado = resultado * numero;
			numero--;
		}

		return resultado;

	}

	public static void main(String[] args) {

		long numero = 1000;
		System.out.print("Fatorial = ");
		System.out.print(calculaFatorial(numero));

		System.out.print("\nFatorial Recursivo = ");
		System.out.print(calculaFatorialRecursivo(numero));

		System.out.print("\nFibonacci = ");
		System.out.print(calculaTermoFibonacciRecursivo(8));

	}

}
