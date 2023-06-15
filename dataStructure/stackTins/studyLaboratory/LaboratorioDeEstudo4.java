package studyLaboratory;

import java.util.Scanner;
import java.util.StringTokenizer;

import unitins.StackTins;

public class LaboratorioDeEstudo4 {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);

		StackTins<String> pilha = new StackTins<String>();

		System.out.print("Informe algum nome: ");
		String nome = leitor.nextLine();

		StringTokenizer st = new StringTokenizer(nome, " ");

		int count = 0;
		while (st.hasMoreTokens()) {
			if (count == 0) {
				pilha.push(st.nextToken().charAt(0) + ". ");
			} else {
				pilha.push(st.nextToken() + ", ");
			}
			count++;
		}

		while (!pilha.isEmpty()) {
			System.out.print(pilha.pop());
		}

		leitor.close();

	}

}
