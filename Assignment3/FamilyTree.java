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

    // Wrapper to avoid static preIndex bug
    static Node buildTree(String[] preorder, String[] inorder) {
        Map<String, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);  // O(1) lookup later
        }
        int[] preIndex = {0}; // array trick to mutate inside recursion
        return buildHelper(preorder, inorderMap, preIndex, 0, inorder.length - 1);
    }

    static Node buildHelper(String[] preorder, Map<String, Integer> inorderMap,
                             int[] preIndex, int start, int end) {
        if (start > end) return null;
        String val = preorder[preIndex[0]++];
        Node root = new Node(val);
        int inIndex = inorderMap.get(val); // O(1) instead of O(n) scan
        root.left  = buildHelper(preorder, inorderMap, preIndex, start, inIndex - 1);
        root.right = buildHelper(preorder, inorderMap, preIndex, inIndex + 1, end);
        return root;
    }

    static void printCousins(Node root) {
        if (root == null) return;

        // BFS — store each node alongside its parent
        // Queue entries: [node, parentNode]
        Queue<Node[]> queue = new LinkedList<>();
        queue.add(new Node[]{root, null});

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Map from parentNode -> list of children at this level
            Map<Node, List<String>> parentToChildren = new LinkedHashMap<>();

            for (int i = 0; i < size; i++) {
                Node[] entry  = queue.poll();
                Node   curr   = entry[0];
                Node   parent = entry[1];

                // Group by parent
                parentToChildren
                    .computeIfAbsent(parent, k -> new ArrayList<>())
                    .add(curr.val);

                if (curr.left  != null) queue.add(new Node[]{curr.left,  curr});
                if (curr.right != null) queue.add(new Node[]{curr.right, curr});
            }

            // Collect all nodes at this depth
            List<String> allAtDepth = new ArrayList<>();
            parentToChildren.values().forEach(allAtDepth::addAll);

            if (allAtDepth.size() > 1) {
                // Cousins = same depth, DIFFERENT parents
                // Build cousin pairs across different parent groups
                List<List<String>> siblingGroups = new ArrayList<>(parentToChildren.values());

                Set<String> cousinSet = new LinkedHashSet<>();
                for (int i = 0; i < siblingGroups.size(); i++) {
                    for (int j = i + 1; j < siblingGroups.size(); j++) {
                        // Every node in group i is cousin with every node in group j
                        cousinSet.addAll(siblingGroups.get(i));
                        cousinSet.addAll(siblingGroups.get(j));
                    }
                }

                if (!cousinSet.isEmpty()) {
                    System.out.println("Cousins at depth " + depth + ": " + cousinSet);
                }

                // Also show siblings for clarity
                for (Map.Entry<Node, List<String>> entry : parentToChildren.entrySet()) {
                    if (entry.getKey() != null && entry.getValue().size() > 1) {
                        System.out.println("  Siblings (not cousins) under "
                            + entry.getKey().val + ": " + entry.getValue());
                    }
                }
            }
            depth++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter preorder (space-separated): ");
        String[] preorder = sc.nextLine().trim().split("\\s+");

        System.out.print("Enter inorder  (space-separated): ");
        String[] inorder  = sc.nextLine().trim().split("\\s+");

        Node root = buildTree(preorder, inorder);
        System.out.println("\nTree built successfully. Root: " + root.val);
        System.out.println();
        printCousins(root);
    }
}
