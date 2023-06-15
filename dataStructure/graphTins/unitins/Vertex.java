package unitins;

public class Vertex {

	Node nodeA  = null;
	Node nodeB = null;
	int cost = 0;

	public Vertex(Node nodeA, Node nodeB, int cost) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return nodeA.info + " <--" + cost + "--> " + nodeB.info;
	}

}
