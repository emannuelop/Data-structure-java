package unitins;

public class TreeTins {

	private Node rootNode;

	public boolean isEmpty() {
		return rootNode == null;
	}

	public void filHeight1() {
		filHeight2(rootNode);
	}

	private int filHeight2(Node subRoot) {
		if (subRoot == null) {
			return 0;
		}

		int leftHeight = filHeight2(subRoot.getLeftNode());
		int rightHeight = filHeight2(subRoot.getRightNode());

		int balance = leftHeight - rightHeight;

		System.out.println(subRoot.getInfo() + " " + balance);

		if (balance < -1 || balance > 1) {
			// balancear(subRoot);
			System.out.println(subRoot.getInfo() + " | Nó desbalanceado");
		}
		return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;

	}

	// Inserir
	public void addNode1(String info) {
		if (isEmpty()) {
			rootNode = new Node(info);
		} else {
			addNode2(info, rootNode);
		}
	}

	private void addNode2(String info, Node subRoot) {
		if (info.compareTo(subRoot.getInfo()) < 0) {
			if (subRoot.getLeftNode() == null) {
				subRoot.setLeftNode(new Node(info));
			} else {
				addNode2(info, subRoot.getLeftNode());
			}
		} else if (info.compareTo(subRoot.getInfo()) > 0) {
			if (subRoot.getRightNode() == null) {
				subRoot.setRightNode(new Node(info));
			} else {
				addNode2(info, subRoot.getRightNode());
			}
		}
	}

	// Procurar
	public boolean find1(String info) {
		return find2(info, rootNode);
	}

	public boolean find2(String info, Node subRoot) {

		try {
			if (subRoot == null)
				return false;
		} catch (Exception e) {

		}

		if (info.compareTo(subRoot.getInfo()) == 0) {
			return true;
		} else if (info.compareTo(subRoot.getInfo()) > 0) {
			return find2(info, subRoot.getRightNode());
		} else {
			return find2(info, subRoot.getLeftNode());
		}
	}

	// Remover
	public void remove1(String info) {
		rootNode = remove2(rootNode, info);
	}

	private Node remove2(Node current, String info) {
		if (current == null) {
			return null;
		}

		if (info.compareTo(current.getInfo()) < 0) {
			current.setLeftNode(remove2(current.getLeftNode(), info));
		} else if (info.compareTo(current.getInfo()) > 0) {
			current.setRightNode(remove2(current.getRightNode(), info));
		} else {
			if (current.getLeftNode() == null) {
				return current.getRightNode();
			} else if (current.getRightNode() == null) {
				return current.getLeftNode();
			}

			Node temp = findMinNode(current.getRightNode());
			current.setInfo(temp.getInfo());
			current.setRightNode(remove2(current.getRightNode(), temp.getInfo()));
		}

		return current;
	}

	private Node findMinNode(Node node) {
		Node current = node;
		while (current.getLeftNode() != null) {
			current = current.getLeftNode();
		}
		return current;
	}

	// Printar
	public void printPreOrder() {
		System.out.print("Pre-order: ");
		printPreOrder(rootNode);
		System.out.println();
	}

	private void printPreOrder(Node node) {
		if (node != null) {
			System.out.print(node.getInfo() + " ");
			printPreOrder(node.getLeftNode());
			printPreOrder(node.getRightNode());
		}
	}

	public void printInOrder() {
		System.out.print("In-order: ");
		printInOrder(rootNode);
		System.out.println();
	}

	private void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.getLeftNode());
			System.out.print(node.getInfo() + " ");
			printInOrder(node.getRightNode());
		}
	}

	public void printPostOrder() {
		System.out.print("Post-order: ");
		printPostOrder(rootNode);
		System.out.println();
	}

	private void printPostOrder(Node node) {
		if (node != null) {
			printPostOrder(node.getLeftNode());
			printPostOrder(node.getRightNode());
			System.out.print(node.getInfo() + " ");
		}
	}

}
