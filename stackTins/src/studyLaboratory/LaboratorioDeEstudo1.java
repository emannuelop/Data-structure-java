package studyLaboratory;

import unitins.StackTins;

public class LaboratorioDeEstudo1 {

	public static void main(String[] args) {

		StackTins<String> pilha = new StackTins<String>();

		pilha.push("Fusca");
		pilha.push("New Fiesta");
		pilha.push("Corolla");
		pilha.push("Hilux");
		pilha.push("Ferrari");
		pilha.push("Lamborghini");

		while (!pilha.isEmpty()) {
			System.out.println(pilha.pop());
		}

	}

}
