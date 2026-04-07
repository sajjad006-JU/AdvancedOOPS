// 3. Given preorder and inorder traversal outcomes of a family tree, construct and return the 
// corresponding binary tree. If two nodes in the tree has the same depth then they are 
// cousins. So, print the names who are cousins in generations of the family history. Try to use 
// java collections classes and functions as much as you can.
// Sajjad Ahmed Shaaz, 002410501093

import java.util.*;

class Node {
    String val;
    Node left, right;

    Node(String v) { val = v; }
}

public class FamilyTree {
    static int preIndex = 0;

    static Node buildTree(String[] preorder, String[] inorder, int start, int end) {
        if (start > end) return null;

        Node root = new Node(preorder[preIndex++]);

        int inIndex = start;
        for (int i = start; i <= end; i++) {
            if (inorder[i].equals(root.val)) {
                inIndex = i;
                break;
            }
        }

        root.left = buildTree(preorder, inorder, start, inIndex - 1);
        root.right = buildTree(preorder, inorder, inIndex + 1, end);

        return root;
    }

    static void printCousins(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<String> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                level.add(curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            if (level.size() > 1)
                System.out.println("Cousins at same level: " + level);
        }
    }

    public static void main(String[] args) {
        String[] preorder = {"A","B","D","E","C","F"};
        String[] inorder = {"D","B","E","A","F","C"};

        Node root = buildTree(preorder, inorder, 0, inorder.length - 1);
        printCousins(root);
    }
}