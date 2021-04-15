package implementation;

import myinterface.BinarySearchTreeADT;


public class MyBinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeADT<E> {
    //complete this class
    Node<E> root = null;

    @Override
    public void insert(E data) {
        Node<E> node = new implementation.Node<>(data);
        if (isEmpty()) {
            root = node;
        } else {
            Node<E> temp = root;
            Node<E> parent = null;
            while (temp != null) {
                parent = temp;
                if (data.compareTo(temp.getData()) <= 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
            if (data.compareTo(parent.getData()) <= 0) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
    }

    private boolean isEmpty() {
        if (root == null) return true;
        return false;
    }

    @Override
    public boolean search(E searchElement) {
        boolean response = false;
        Node<E> temp = root;
        while (temp != null) {
            if (searchElement.compareTo(temp.getData()) == 0) {
                response = true;
                break;
            } else if (searchElement.compareTo(temp.getData()) < 0) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return response;

    }

    @Override
    public void inOrder(Node<E> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData() + " , ");
            inOrder(node.getRight());
        }

    }

    @Override
    public void preOrder(Node<E> node) {

    }

    @Override
    public void postOrder(Node<E> node) {

    }

    @Override
    public void reverseInOrder(Node<E> node) {

    }

    @Override
    public void delete(E data) {
        Node<E> temp = root;
        Node<E> parent = null;
        while (temp != null) {
            if (data.compareTo(temp.getData()) == 0) {
                break;
            } else {
                parent = temp;
                if (data.compareTo(temp.getData()) < 0) {
                    temp = temp.getLeft();

                } else {
                    temp = temp.getRight();
                }

            }
        }
        if (temp != null) {
            if (isLeaf(temp)) {
                if (parent == null) {
                    root = null;

                } else {
                    if (data.compareTo(parent.getData()) < 0) {
                        parent.setLeft(null);
                    } else {
                        parent.setRight(null);
                    }
                }

            } else if (hasLeftChild(temp)) {
                if (parent == null) {
                    root = root.getLeft();
                } else {
                    if (data.compareTo(parent.getData()) < 0) {
                        parent.setLeft(temp.getLeft());
                    } else {
                        parent.setRight(temp.getLeft());
                    }
                }

            } else if (hasRightChild(temp)) {
                if (parent == null) {
                    root = root.getRight();
                } else {
                    if (data.compareTo(parent.getData()) < 0) {
                        parent.setLeft(temp.getRight());
                    } else {
                        parent.setRight(temp.getRight());
                    }
                }
            }
        } else {
            Node<E> successor = getSuccessor(temp);
            delete(successor.getData());
            successor.setLeft(temp.getLeft());
            successor.setRight(temp.getRight());
            if (parent == null) {
                root = successor;
            } else {
                if (data.compareTo(parent.getData()) < 0) {
                    parent.setLeft(successor);
                } else {
                    System.out.println("cannot delete");
                }
            }
        }

    }

    private boolean isLeaf(Node<E> temp) {
        if(temp.getLeft() == null && temp.getRight() == null){
            return true;
        }return false;
    }



    private boolean hasLeftChild(Node<E> temp) {
        if(temp.getLeft() != null && temp.getRight() == null){
            return true;
        }
        return false;
    }

    private boolean hasRightChild(Node<E> temp) {
        if (temp.getLeft() != null && temp.getRight() == null) {
            return true;
        }
        return false;
    }

    private Node<E> getSuccessor(Node<E> temp) {
        Node<E> response = null;
        Node<E> temp = node.getRight();
        while (temp.getLeft() != null) {
            temp = temp.getLeft();

        }
        response = temp;
        return response;

    }

    @Override
    public int height(Node<E> node) {
        return 0;
    }
}
