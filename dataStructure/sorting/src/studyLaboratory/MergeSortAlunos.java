package studyLaboratory;

import java.util.List;
import java.util.ArrayList;

public class MergeSortAlunos {

	public static class Aluno {
		private String nome;
		private double nota;

		public Aluno(String nome, double nota) {
			this.nome = nome;
			this.nota = nota;
		}

		public String getNome() {
			return nome;
		}

		public double getNota() {
			return nota;
		}
	}

	public static void mergeSortAlunos(List<Aluno> listaAlunos, String criterio) {
		if (listaAlunos.size() > 1) {
			int meio = listaAlunos.size() / 2;
			List<Aluno> metadeEsquerda = new ArrayList<>(listaAlunos.subList(0, meio));
			List<Aluno> metadeDireita = new ArrayList<>(listaAlunos.subList(meio, listaAlunos.size()));

			mergeSortAlunos(metadeEsquerda, criterio);
			mergeSortAlunos(metadeDireita, criterio);

			int indiceEsquerda = 0, indiceDireita = 0, indiceResultado = 0;
			while (indiceEsquerda < metadeEsquerda.size() && indiceDireita < metadeDireita.size()) {
				if (criterio.equals("nome")) {
					if (metadeEsquerda.get(indiceEsquerda).getNome()
							.compareToIgnoreCase(metadeDireita.get(indiceDireita).getNome()) < 0) {
						listaAlunos.set(indiceResultado++, metadeEsquerda.get(indiceEsquerda++));
					} else {
						listaAlunos.set(indiceResultado++, metadeDireita.get(indiceDireita++));
					}
				} else if (criterio.equals("nota")) {
					if (metadeEsquerda.get(indiceEsquerda).getNota() < metadeDireita.get(indiceDireita).getNota()) {
						listaAlunos.set(indiceResultado++, metadeEsquerda.get(indiceEsquerda++));
					} else {
						listaAlunos.set(indiceResultado++, metadeDireita.get(indiceDireita++));
					}
				}
			}

			while (indiceEsquerda < metadeEsquerda.size()) {
				listaAlunos.set(indiceResultado++, metadeEsquerda.get(indiceEsquerda++));
			}

			while (indiceDireita < metadeDireita.size()) {
				listaAlunos.set(indiceResultado++, metadeDireita.get(indiceDireita++));
			}
		}
	}

	public static void main(String[] args) {
		List<Aluno> listaAlunos = new ArrayList<>();
		listaAlunos.add(new Aluno("João", 8.5));
		listaAlunos.add(new Aluno("Maria", 9.0));
		listaAlunos.add(new Aluno("Pedro", 7.0));
		listaAlunos.add(new Aluno("Ana", 8.0));

		System.out.println("Lista de alunos desordenada:");
		for (Aluno aluno : listaAlunos) {
			System.out.println("Nome: " + aluno.getNome() + ", nota: " + aluno.getNota());
		}

		mergeSortAlunos(listaAlunos, "nome");

		System.out.println("\nLista de alunos ordenada por nome:");
		for (Aluno aluno : listaAlunos) {
			System.out.println("Nome: " + aluno.getNome() + ", nota: " + aluno.getNota());
		}

		mergeSortAlunos(listaAlunos, "nota");

		System.out.println("\nLista de alunos ordenada por nota:");
		for (Aluno aluno : listaAlunos) {
			System.out.println("Nome: " + aluno.getNome() + ", nota: " + aluno.getNota());
		}

	}
}
