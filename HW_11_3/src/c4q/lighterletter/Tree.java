package c4q.lighterletter;


import java.util.ArrayDeque;
import java.util.Queue;
public class Tree
{
    //MVC: Binary Search tree implementation using recursion.
    Node root;

    //public method
    public boolean exists(int data)
    {
        return exists_recurse(root,data);
    }

    //internal recursive method
    private boolean exists_recurse(Node node, int data) {
     if (node == null) return false;

        //Check to see if data is greater than or less
        //than current node's data
        int symbol = asInt(node.symbol);

        if (data < symbol)
        {
            return exists_recurse(node.left, data);
        } else if (data > symbol) {
            return exists_recurse(node.right, data);
        } else
        {
            return true;
        }
    }


    //remember: Charlyn chose to write this recursively. Great job Charlyn!
    // public method
    public int findMin(){
        return findMin_recurse(this.root);
    }

    // internal recursive method
    private int findMin_recurse(Node node){
        if (node == null ){
            throw new IllegalArgumentException("null node");
        }
        if (node.left == null ){
            return asInt(node.symbol);
        }

        return findMin_recurse(node.left);
    }

    // remember: Jorge wrote this iteratively. Great job Jorge!
    public int findMax(){
        if(root == null){
            throw new IllegalArgumentException("null node");
        }

        Node node = root;
        while (node.right != null){
            node = node.right;
        }

        return asInt(node.symbol);
    }

    //Only iteative; breadth-first search
    public void  printBreadth(){
        if (root == null) return;

        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.symbol + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }

        //if you're here, then you've printed all the nodes
        //don't forget to end the output line with a newline ('\n')
        System.out.println();
    }

    //public method
    public void printPostfix() {
        printPostfix_recurse(root);

        //don't forget to end the output line with a newline ('\n')
        System.out.println();
    }

    //internal recursive method
    private void printPostfix_recurse(Node node) {
        if(node == null) return;

        printPostfix_recurse(node.left);
        printPostfix_recurse(node.right);
        System.out.print(node.symbol + " ");
    }

    // public method
    public void printPrefix(){
        printPrefix_recurse(root);

        //don't forget to end the output line with a newline ('\n')
        System.out.println();
    }

    // internal recursive method
    private void printPrefix_recurse(Node node) {
        if ( node == null) return;

        System.out.print(node.symbol + " ");
        printPrefix_recurse(node.left);
        printPrefix_recurse(node.right);
    }

    // public method
    public void printInfix() {
        printInfix_recurse(root);

        //don't forget to end the output line with a newline('\n')
        System.out.println();
    }

    // internal recursive method
    private void printInfix_recurse(Node node) {
        if (node == null ) return;

        printInfix_recurse(node.left);
        System.out.print(node.symbol + " ");
        printInfix_recurse(node.right);
    }

    private static int asInt(String s) {
        return Integer.parseInt(s);
    }


}

class Node
{
    Node left;
    Node right;
    String symbol;

    public Node(String s)
    {
        this.symbol = s;
    }

    public boolean add(int value) {
        Node node = new Node(String.valueOf(value));

        if (value == Integer.parseInt(this.symbol))
            return false;
        else if (value < Integer.parseInt(this.symbol)) {
            if (left == null) {
                left = node;
                return true;
            } else
                return left.add(value);
        } else if (value > Integer.parseInt(this.symbol)) {
            if (right == null) {
                right = new Node(String.valueOf(value));
                return true;
            } else
                return right.add(value);
        }
        return false;
    }

}
