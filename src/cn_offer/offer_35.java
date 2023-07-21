package cn_offer;

class Solution_Offer_35 {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node node = head;
        while (node != null) {
            Node next = node.next;
            node.next = new Node(node.val);
            node.next.next = next;
            node = next;
        }
        node = head;
        while (node != null) {
            Node random = node.random;
            node.next.random = random == null ? null : random.next;
            node = node.next.next;
        }
        Node dummy = new Node(0);
        Node temp = dummy;
        node = head;
        while (node != null) {
            Node next = node.next;
            node.next = next.next;
            node = node.next;
            temp.next = next;
            temp = next;
        }
        return dummy.next;
    }
}