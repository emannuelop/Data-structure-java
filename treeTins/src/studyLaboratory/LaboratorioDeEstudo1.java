package studyLaboratory;

import unitins.TreeTins;

public class LaboratorioDeEstudo1 {

	public static void main(String[] args) {

		TreeTins tree = new TreeTins();
		tree.addNode1("Z");
		tree.addNode1("L");
		tree.addNode1("C");
		tree.addNode1("B");
		tree.addNode1("D");
		tree.addNode1("G");
		tree.addNode1("H");
		tree.addNode1("I");
		tree.addNode1("E");

		System.out.println("---------------------");
		System.out.println("Imprime a árvore nas três ordens");
		tree.printPreOrder();
		tree.printInOrder();
		tree.printPostOrder();

		System.out.println("---------------------");
		System.out.println("Procurando um nó");
		System.out.println(tree.find1("G"));
		System.out.println(tree.find1("D"));
		System.out.println(tree.find1("Z"));

		System.out.println("---------------------");
		System.out.println("Removendo");
		System.out.println("Antes de apagar: " + tree.find1("I"));
		tree.remove1("I");
		System.out.println("Depois de apagar: " + tree.find1("I"));
		
		System.out.println("---------------------");
		
		tree.filHeight1();

	}

}
