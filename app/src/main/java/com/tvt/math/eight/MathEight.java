package com.tvt.math.eight;

/**
 * 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 */
class MathEight {

    MathEight() {
    }

    static class TreeLinkNode {
        String value;
        TreeLinkNode left; // 左子节点
        TreeLinkNode right; // 右子节点
        TreeLinkNode parent; // 父节点

        public TreeLinkNode(String value) {
            this.value = value;
        }
    }

    // 中序遍历，左父右的顺序遍历
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 如果存在右子节点，则读取右子节点，再读取右子节点的左子节点，
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        }
        else {
            while (pNode.parent != null) {
                TreeLinkNode parent = pNode.parent;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.parent;
            }
        }
        return null;
    }

}
