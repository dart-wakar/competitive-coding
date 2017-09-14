import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left,right;
}

class BinarySearchTree {

    Node root;

    private Node insertNode(Node x,int data) {
        if(x == null) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.left = null;
            newNode.right = null;
            return newNode;
        }
        if(data < x.data) {
            x.left = insertNode(x.left,data);
        } else if(data > x.data) {
            x.right = insertNode(x.right,data);
        }
        return x;
    }

    void insertNode(int data) {
        root = insertNode(root,data);
    }

    Node search(Node root,int key) {
        if(root == null) {
            return null;
        }
        if(root.data == key) {
            return root;
        } else if(root.data < key) {
            return search(root.right,key);
        } else {
            return search(root.left,key);
        }
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = null;
        bst.insertNode(10);
        bst.insertNode(-5);
        bst.insertNode(30);
        bst.insertNode(-10);
        bst.insertNode(0);
        bst.insertNode(5);
        bst.insertNode(30);
        bst.insertNode(36);
        Node searchResult = bst.search(bst.root,30);
        System.out.println(searchResult.data);
        System.out.println(searchResult.right.data);
        System.out.println(bst.root.data);
    }
}