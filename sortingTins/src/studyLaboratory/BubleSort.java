package studyLaboratory;


public class BubleSort {

	public static void bubleSort(int[] array) {

		int aux = 0;
		boolean trocou = false;

		// Pior forma de fazer
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array.length - 1; j++) {
//				System.out.println(j + " " + (j + 1));
//				if(array[j] > array[j + 1]) {
//					aux = array[j];
//					array[j] = array[j + 1];
//					array[j + 1] = aux;
//				}
//			}
//		}

//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array.length - i - 1; j++) {
//				System.out.println(j + " " + (j + 1));
//				if(array[j] > array[j + 1]) {
//					aux = array[j];
//					array[j] = array[j + 1];
//					array[j + 1] = aux;
//				}
//			}
//		}

		for (int i = 0; i < array.length; i++) {
			trocou = false;
			for (int j = 0; j < array.length - i - 1; j++) {
				System.out.println(j + " " + (j + 1));
				if (array[j] > array[j + 1]) {
					aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
					trocou = true;
				}
			}
			if (trocou == false) {
				return;
			}
		}

	}

	static void imprimeArray(int[] array) {

		for (int i : array) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {

		int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		imprimeArray(array);
		bubleSort(array);
		imprimeArray(array);

	}

}
