package studyLaboratory;

import unitins.QueueTins;

public class LaboratorioDeEstudo {

	public static void main(String[] args) {

		QueueTins<String> fila = new QueueTins<String>();

		fila.enqueue("Fusca");
		fila.enqueue("New Fiesta");
		fila.enqueue("Corolla");
		fila.enqueue("Hilux");
		fila.enqueue("Ferrari");
		fila.enqueue("Lamborghini");

		while (!fila.isEmpty()) {
			System.out.println(fila.dequeue());
		}

	}

}
