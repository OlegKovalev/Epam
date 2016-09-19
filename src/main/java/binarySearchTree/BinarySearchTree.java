package binarySearchTree;

public class BinarySearchTree<K extends Comparable, V> {

    Node<K, V> root;

    public static class Node<K, V> {

        K key;
        V value;

        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }
        public Node<K, V> getLeft() {
            return left;
        }

        public Node<K, V> getRight() {
            return right;
        }
    }

    public V get(K key) {
        return get(root, key);
    }



    private V get(Node<K, V> root, K key) {
        if (root == null) {
            return null;
        }

        int compareResult = key.compareTo(root.key);
        if (compareResult < 0) {
            return get(root.left, key);
        } else if (compareResult > 0) {
            return get(root.right, key);
        } else {
            return root.value;
        }
    }

    public void put(final K key, final V value) {
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> root, K key, V value) {
        if (root == null) {
            return new Node<>(key, value);
        }

        int compareResult = key.compareTo(root.key);
        if (compareResult < 0) {
            root.left = put(root.left, key, value);
        } else if (compareResult > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
        return root;
    }

    private Node<K, V> min(Node root) {
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    private Node<K, V> removeMin(Node<K, V> root) {
        if (root.left == null) {
            return root.right;
        }

        root.left = removeMin(root.left);
        return root;
    }

    public void remove(K key) {
        root = remove(root, key);
    }

    private Node<K, V> remove(Node<K, V> root, K key) {
        if (root == null) {
            return null;
        }
        int compareResult = key.compareTo(root.key);
        if (compareResult < 0) {
            root.left = remove(root.left, key);
        } else if (compareResult > 0) {
            root.right = remove(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            Node tempNode = root;
            root = min(tempNode.right);
            root.right = removeMin(tempNode.right);
            root.left = tempNode.left;
        }
        return root;
    }

    public Node<K, V> getRoot() {
        return root;
    }
}
