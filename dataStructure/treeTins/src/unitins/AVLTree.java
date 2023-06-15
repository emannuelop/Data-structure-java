package unitins;

public class AVLTree {

    private Node rootNode;

    public boolean isEmpty() {
        return rootNode == null;
    }

    public void addNode(String info) {
        if (isEmpty()) {
            rootNode = new Node(info);
        } else {
            rootNode = addNode(rootNode, info);
        }
    }

    private Node addNode(Node node, String info) {
        if (node == null) {
            return new Node(info);
        }

        if (info.compareTo(node.getInfo()) < 0) {
            node.setLeftNode(addNode(node.getLeftNode(), info));
        } else if (info.compareTo(node.getInfo()) > 0) {
            node.setRightNode(addNode(node.getRightNode(), info));
        }

        // Realiza o balanceamento da árvore
        int balance = getBalance(node);

        if (balance > 1) {
            if (info.compareTo(node.getLeftNode().getInfo()) < 0) {
                return rotateRight(node);
            } else {
                node.setLeftNode(rotateLeft(node.getLeftNode()));
                return rotateRight(node);
            }
        } else if (balance < -1) {
            if (info.compareTo(node.getRightNode().getInfo()) > 0) {
                return rotateLeft(node);
            } else {
                node.setRightNode(rotateRight(node.getRightNode()));
                return rotateLeft(node);
            }
        }

        return node;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.getLeftNode()), getHeight(node.getRightNode()));
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeftNode()) - getHeight(node.getRightNode());
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.getLeftNode();
        Node temp = newRoot.getRightNode();

        newRoot.setRightNode(node);
        node.setLeftNode(temp);

        return newRoot;
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.getRightNode();
        Node temp = newRoot.getLeftNode();

        newRoot.setLeftNode(node);
        node.setRightNode(temp);

        return newRoot;
    }

    public boolean find(String info) {
        return find(info, rootNode);
    }

    private boolean find(String info, Node node) {
        if (node == null) {
            return false;
        }

        if (info.compareTo(node.getInfo()) == 0) {
            return true;
        } else if (info.compareTo(node.getInfo()) < 0) {
            return find(info, node.getLeftNode());
        } else {
            return find(info, node.getRightNode());
        }
    }

    public void remove(String info) {
        rootNode = remove(rootNode, info);
    }

    private Node remove(Node node, String info) {
        if (node == null) {
            return null;
        }

        if (info.compareTo(node.getInfo()) < 0) {
            node.setLeftNode(remove(node.getLeftNode(), info));
        } else if (info.compareTo(node.getInfo()) > 0) {
            node.setRightNode(remove(node.getRightNode(), info));
        } else {
            if (node.getLeftNode() == null) {
                return node.getRightNode();
            } else if (node.getRightNode() == null) {
                return node.getLeftNode();
            }

            Node temp = findMinNode(node.getRightNode());
            node.setInfo(temp.getInfo());
            node.setRightNode(remove(node.getRightNode(), temp.getInfo()));
        }

        // Realiza o balanceamento da árvore
        int balance = getBalance(node);

        if (balance > 1) {
            if (getBalance(node.getLeftNode()) >= 0) {
                return rotateRight(node);
            } else {
                node.setLeftNode(rotateLeft(node.getLeftNode()));
                return rotateRight(node);
            }
        } else if (balance < -1) {
            if (getBalance(node.getRightNode()) <= 0) {
                return rotateLeft(node);
            } else {
                node.setRightNode(rotateRight(node.getRightNode()));
                return rotateLeft(node);
            }
        }

        return node;
    }

    private Node findMinNode(Node node) {
        Node current = node;
        while (current.getLeftNode() != null) {
            current = current.getLeftNode();
        }
        return current;
    }

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
