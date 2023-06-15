package studyLaboratory;

import unitins.Graph;
import unitins.Vertex;

public class LaboratorioDeEstudo1 {

	public static void main(String[] args) {

		Graph grafo = new Graph();
		
		grafo.addNode("Palmas");
		grafo.addNode("Porto");
		grafo.addNode("Brejinho");
		grafo.addNode("Paraiso");
		grafo.addNode("Gurupi");
		
		grafo.createVertex(grafo.getNode("Palmas"), grafo.getNode("Porto"), 2);
		grafo.createVertex(grafo.getNode("Porto"), grafo.getNode("Brejinho"), 2);
		grafo.createVertex(grafo.getNode("Brejinho"), grafo.getNode("Gurupi"), 3);
		grafo.createVertex(grafo.getNode("Porto"), grafo.getNode("Gurupi"), 10);
		grafo.createVertex(grafo.getNode("Palmas"), grafo.getNode("Paraiso"), 5);
		grafo.createVertex(grafo.getNode("Paraiso"), grafo.getNode("Gurupi"), 7);
		
		for (Vertex vertex : grafo.vertexList) {
			System.out.println(vertex);
		}
		
		System.out.println("Caminhos");
		grafo.printAllPathsFromTo(grafo.getNode("Palmas"), grafo.getNode("Paraiso"));
		
	}

}
