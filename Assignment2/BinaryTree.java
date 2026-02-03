// 3. Given the root of a binary tree, return all root-to-leaf paths in any order. A leaf is a node with no 
// children. Treat a node as an inner class. Write appropriate code representing the node containing 
// an integer (1>n>100) or a string (6 letter names). You may use ArrayList (List<String> example = new 
// ArrayList<String/Integer>();). 


import java.util.*;

public class BinaryTree<T> {

    class Node {
        T data;
        Node left, right;

        Node(T item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    BinaryTree() {
        root = null;
    }

    void printPaths(Node node, List<T> path) {
        if (node == null) {
            return;
        }

        path.add(node.data);

        if (node.left == null && node.right == null) {
            System.out.println(path);
        } else {
            printPaths(node.left, path);
            printPaths(node.right, path);
        }

        path.remove(path.size() - 1);
    }

    void printAllRootToLeafPaths() {
        List<T> path = new ArrayList<>();
        printPaths(root, path);
    }

    void constructBinaryTreeFromList(List<T> values) {
        if (values == null || values.isEmpty()) {
            return;
        }
        root = constructTreeHelper(values, 0);
    }

    private Node constructTreeHelper(List<T> values, int index) {
        if (index >= values.size()) {
            return null;
        }

        // handle null values in the list
        if (values.get(index) == null) {
            return null;
        }

        Node node = new Node(values.get(index));
        node.left = constructTreeHelper(values, 2 * index + 1);
        node.right = constructTreeHelper(values, 2 * index + 2);
        return node;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> intTree = new BinaryTree<>();
        List<Integer> intValues = Arrays.asList(1, 2, 3, 4, 5);
        intTree.constructBinaryTreeFromList(intValues);
        System.out.println("Root-to-leaf paths for Integer Binary Tree:");
        intTree.printAllRootToLeafPaths();

        BinaryTree<String> strTree = new BinaryTree<>();
        List<String> strValues = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace");
        strTree.constructBinaryTreeFromList(strValues);
        System.out.println("Root-to-leaf paths for String Binary Tree:");
        strTree.printAllRootToLeafPaths();
    }    
}
