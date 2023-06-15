package studyLaboratory;

import java.util.Scanner;

import unitins.StackTins;

public class LaboratorioDeEstudo2 {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);

		StackTins<String> pilha = new StackTins<String>();

		System.out.print("Informe algum nome: ");
		String nome = leitor.nextLine();

		char aux1[] = nome.toCharArray();
		String aux2[] = new String[nome.length()];

		for (int i = 0; i < nome.length(); i++) {
			aux2[i] = String.valueOf(aux1[i]);
			pilha.push(aux2[i]);
		}

		while (!pilha.isEmpty()) {
			System.out.print(pilha.pop());
		}

		leitor.close();

	}

}
