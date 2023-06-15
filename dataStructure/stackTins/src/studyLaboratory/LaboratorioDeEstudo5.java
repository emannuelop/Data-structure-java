package studyLaboratory;

public class LaboratorioDeEstudo5 {

	static void metodoB(int valor) {

		if (valor == 100) {
			return;
		}

		metodoB(valor + 1);

		System.out.println(valor);
	}

	public static void main(String[] args) {

		int numero = 0;

		metodoB(numero);

	}

}
