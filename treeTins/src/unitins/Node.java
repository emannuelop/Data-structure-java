package unitins;

public class Node {

	private String info;
	private Node leftNode;
	private Node rightNode;

	public Node(String info) {
		this.info = info;
		this.leftNode = null;
		this.rightNode = null;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

}
