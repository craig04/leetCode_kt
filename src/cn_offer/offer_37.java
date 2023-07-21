package cn_offer;

import base.TreeNode;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("n ");
            return;
        }
        sb.append(root.val).append(' ');
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data.toCharArray(), new int[]{0});
    }

    private TreeNode deserialize(char[] data, int[] pos) {
        if (data[pos[0]] == 'n') {
            pos[0] += 2;
            return null;
        }
        boolean negative = false;
        if (data[pos[0]] == '-') {
            negative = true;
            pos[0]++;
        }
        int val = 0;
        while (data[pos[0]] != ' ') {
            val = data[pos[0]] - '0' + val * 10;
            pos[0]++;
        }
        pos[0]++;
        if (negative)
            val = -val;
        TreeNode node = new TreeNode(val);
        node.left = deserialize(data, pos);
        node.right = deserialize(data, pos);
        return node;
    }
}