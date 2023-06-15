package unitins;

import java.util.ArrayList;

public class Node {

	ArrayList<Vertex> edges;
	String info = "";

	Node(String info) {
		this.info = info;
		this.edges = new ArrayList<>();
	}

}
