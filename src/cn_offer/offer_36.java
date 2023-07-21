package cn_offer;

class Solution_Offer_36 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private final Node head = new Node();
    private Node tail = head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root);
        head.right.left = tail;
        tail.right = head.right;
        return head.right;
    }

    private void traverse(Node root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        tail.right = root;
        root.left = tail;
        tail = root;
        traverse(root.right);
    }
}