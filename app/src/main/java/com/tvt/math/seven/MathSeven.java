package com.tvt.math.seven;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 *
 * <p>前序遍历：先访问根节点，再访问左节点，最后访问右节点</p>
 * <p>中序遍历：先访问左节点，再访问根节点，最后访问右节点</p>
 * <p>后序遍历：先访问左节点，再访问右节点，最后访问根节点</p>
 * <p>宽度遍历：先访问第一层的根节点，左节点，右节点，再访问第二层的节点</p>
 */
class MathSeven {

    MathSeven() {
    }

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;


        public TreeNode(int value) {
            this.value = value;
        }
    }

    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.value);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

}
