package studyLaboratory;

import java.util.Scanner;

import unitins.StackTins;

public class LaboratorioDeEstudo3 {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);

		StackTins<String> pilha = new StackTins<String>();

		System.out.print("Informe algum nome: ");
		String nome = leitor.nextLine();

		for (int i = 0; i < nome.length(); i++) {
			pilha.push(nome.charAt(i) + "");
		}

		while (!pilha.isEmpty()) {
			System.out.print(pilha.pop());
		}

		leitor.close();

	}

}
