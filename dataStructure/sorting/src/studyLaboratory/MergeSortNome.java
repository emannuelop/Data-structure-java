package studyLaboratory;

import java.util.ArrayList;
import java.util.List;

public class MergeSortNome {

	public static void mergeSort(List<String> nomes) {
		if (nomes.size() > 1) {
			int mid = nomes.size() / 2;
			List<String> left = new ArrayList<>(nomes.subList(0, mid));
			List<String> right = new ArrayList<>(nomes.subList(mid, nomes.size()));
			mergeSort(left);
			mergeSort(right);
			merge(nomes, left, right);
		}
	}

	public static void merge(List<String> nomes, List<String> esquerdo, List<String> direito) {

		int indiceEsquerda = 0, indiceDireita = 0, indiceResultado = 0;
		while (indiceEsquerda < esquerdo.size() && indiceDireita < direito.size()) {
			if (esquerdo.get(indiceEsquerda).compareToIgnoreCase(direito.get(indiceDireita)) < 0) {
				nomes.set(indiceResultado, esquerdo.get(indiceEsquerda));
				indiceEsquerda++;
			} else {
				nomes.set(indiceResultado, direito.get(indiceDireita));
				indiceDireita++;
			}
			indiceResultado++;
		}

		while (indiceEsquerda < esquerdo.size()) {
			nomes.set(indiceResultado, esquerdo.get(indiceEsquerda));
			indiceEsquerda++;
			indiceResultado++;
		}

		while (indiceDireita < direito.size()) {
			nomes.set(indiceResultado, direito.get(indiceDireita));
			indiceDireita++;
			indiceResultado++;
		}

	}

	public static void main(String[] args) {
		List<String> nomes = new ArrayList<>();
		nomes.add("Maria");
		nomes.add("Ana");
		nomes.add("José");
		nomes.add("Carlos");
		nomes.add("Bianca");

		System.out.println("Depois ordenação: " + nomes);
		mergeSort(nomes);
		System.out.println("Antes ordenação: " + nomes);
	}

}
