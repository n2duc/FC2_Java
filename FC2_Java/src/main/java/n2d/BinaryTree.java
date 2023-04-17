/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package n2d;

/**
 *
 * @author N2DUC
 */
class TNode {
    int data;
    TNode left, right;
    TNode (int x) {
        data = x;
        left = right = null;
    }
    TNode (int x, TNode ll, TNode rr) {
        data = x;
        left = ll;
        right = rr;
    }
}
public class BinaryTree {
    TNode root;
    void createTree() {
        TNode G = new TNode(5, new TNode(6), new TNode(2));
        TNode E = new TNode(9, null, new TNode(0));
        TNode D = new TNode(1, null, G);
        TNode C = new TNode(2, new TNode(4), E);
        TNode B = new TNode(7, D, null);
        TNode A = new TNode(3, null, C);
        root = new TNode(8, A, B);
    }
    void duyet1(TNode T) {
        if (T != null) {
            System.out.print(" " + T.data);
            duyet1(T.left);
            duyet1(T.right);
        }
    }
    void duyettientu() {
        duyet1(root);
    }
    // So luong Node trong cay nhi phan
    int soNode(TNode T) {
        if (T == null) return 0;
        else return 1 + soNode(T.left) + soNode(T.right);
    }
    int slNode() {
        return soNode(root);
    }
    // Tong gia tri Node
    int tongNode(TNode T) {
        if (T == null) return 0;
        else return T.data + tongNode(T.left) + tongNode(T.right);
    } 
    int tong() {
        return tongNode(root);
    }
    // So luong Node la'
    int leafNode(TNode T) {
        if (T == null) return 0;
        else if (T.right == null && T.left == null) {
            return 1 + leafNode(T.left) + leafNode(T.right);
        } else {
            return leafNode(T.left) + leafNode(T.right);
        }
    }
    int leaf() {
        return leafNode(root);
    }
    // Tong gia tri Node trong (khong phai Node la')
    int isNotLeaf(TNode T) {
        if (T == null) return 0;
        else if (T.left != null || T.right != null) {
            return T.data + isNotLeaf(T.left) + isNotLeaf(T.right);
        } else {
            return isNotLeaf(T.left) + isNotLeaf(T.right);
        }
    }
    int tongNodeTrong() {
        return isNotLeaf(root);
    }
    // Tong cac Node co gia tri le?
    int oddNode(TNode T) {
        if (T == null) return 0;
        else if (T.data % 2 != 0) {
            return T.data + oddNode(T.left) + oddNode(T.right);
        } else {
            return oddNode(T.left) + oddNode(T.right);
        }
    }
    int tongNodeLe() {
        return oddNode(root);
    }
    // Dem so Node co 1 con
    int Node1Con(TNode T) {
        if (T == null) return 0;
        else if ((T.left != null && T.right == null) || (T.left == null && T.right != null)) {
            return 1 + Node1Con(T.left) + Node1Con(T.right);
        } else {
            return Node1Con(T.left) + Node1Con(T.right);
        }
    }
    int soNode1Con() {
        return Node1Con(root);
    }
    // Chieu cao cua cay
    int heightTree(TNode T) {
        if (T == null) return 0;
        else {
            int leftTree = heightTree(T.left);
            int rightTree = heightTree(T.right);
            if (leftTree >= rightTree) {
                return leftTree + 1;
            } else {
                return rightTree + 1;
            }
        }
    }
    int height() {
        return heightTree(root);
    }
    // Kiem tra cay co can bang khong
    boolean isBalance(TNode T) {
        if (T == null) return true;
        else return false;
    }
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.createTree();
        b.duyettientu();
        System.out.println("\nSo luong Node: " + b.slNode());
        System.out.println("Tong gia tri Node: " + b.tong());
        System.out.println("So luong Node La': " + b.leaf());
        System.out.println("Tong Node trong: " + b.tongNodeTrong());
        System.out.println("Tong Node Le?: " + b.tongNodeLe());
        System.out.println("So luong Node co 1 con: " + b.soNode1Con());
        System.out.println("Chieu cao cua cay: " + b.height());
    }
}
