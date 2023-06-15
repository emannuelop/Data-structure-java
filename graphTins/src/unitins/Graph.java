package unitins;

import java.util.ArrayList;

public class Graph {

	public ArrayList<Node> nodeList = new ArrayList<>();
	public ArrayList<Vertex> vertexList = new ArrayList<>();

	public Node addNode(String info) {
		Node newNode = new Node(info);
		nodeList.add(newNode);
		return newNode;
	}

	public Node getNode(String info) {
		for (Node node : nodeList) {
			if (node.info.equals(info)) {
				return node;
			}
		}
		return addNode(info);
	}

	public void createVertex(String infoNodeA, String infoNodeB, int cost) {
		createVertex(getNode(infoNodeA), getNode(infoNodeB), cost);
	}

	public void createVertex(Node nodeA, Node nodeB, int cost) {
		Vertex newVertex = new Vertex(nodeA, nodeB, cost);
		vertexList.add(newVertex);
	}
	
	// Caminhos possiveis

	public void printAllPathsFromTo(Node nodeA, Node nodeB) {
		ArrayList<Node> visited = new ArrayList<>();
		visited.add(nodeA);
		printAllPathsUtil(nodeA, nodeB, visited);
	}

	private void printAllPathsUtil(Node currentNode, Node destination, ArrayList<Node> visited) {
		if (currentNode == destination) {
			for (Node node : visited) {
				System.out.print(node.info + " ");
			}
			System.out.println();
			return;
		}

		for (Vertex vertex : vertexList) {
			if (vertex.nodeA == currentNode && !visited.contains(vertex.nodeB)) {
				visited.add(vertex.nodeB);
				printAllPathsUtil(vertex.nodeB, destination, visited);
				visited.remove(vertex.nodeB);
			} else if (vertex.nodeB == currentNode && !visited.contains(vertex.nodeA)) {
				visited.add(vertex.nodeA);
				printAllPathsUtil(vertex.nodeA, destination, visited);
				visited.remove(vertex.nodeA);
			}
		}
	}

}
