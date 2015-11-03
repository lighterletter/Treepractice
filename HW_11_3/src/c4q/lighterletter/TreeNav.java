package c4q.lighterletter;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by c4q-john on 11/3/15.
 */
public class TreeNav
{
    public static void main(String[] args)
    {
        //This section deals with forming an expression tree from an expression

        String expression = " a b + c d e + * *";
        System.out.println("expression: " + expression);

        Tree expressionTree = formExpressionTree(expression);

        System.out.print("postfix: ");
        expressionTree.printPostfix();

        System.out.print("prefix: ");
        expressionTree.printPrefix();

        System.out.print("infix: ");
        expressionTree.printInfix();

        System.out.print("breadth: ");
        expressionTree.printBreadth();

        // This section deals with Binary Seach Trees (BSTs)

        Tree BST = makeBST();
        System.out.println("does exist?: " + BST. exists(7));
        System.out.println("min?: " + BST.findMin()); //should be 1 after insert(1)
        System.out.println("max?: " + BST.findMax()); //should be 13 after insert(13)


        // insert
        System.out.println("Enter int to insert");
        Scanner scanner = new Scanner(System.in);


        int value = Integer.parseInt(scanner.next());
        boolean addedSuccessfully = add(value);


        System.out.println("you entered: " + value);
        System.out.println("did it add successfully?" + addedSuccessfully);

        System.out.println("current min?: " + BST.findMin()); //should be 1 after insert(1)
        System.out.println("current max?: " + BST.findMax()); //should be 13 after insert(13)
    }

    public static boolean add(int value) {
        Node node = new Node(String.valueOf(value));
        Tree tree = new Tree();
        if (tree.root == null) {
            tree.root = node;
            return true;
        } else
            return tree.root.add(value);
    }

    private static Tree makeBST() {
        Node ten = new Node("10");
        Node five = new Node("5");
        Node twelve = new Node("12");
        Node two = new Node("2");
        Node six = new Node ("6");
        Node three = new Node("3");
        Node four = new Node("4");

        three.right = four;
        two.right = three;
        five.left = two;
        five.right = six;
        ten.left = five;
        ten.right = twelve;

        Tree tree = new Tree();
        tree.root = ten;
        return tree;
    }

    private static Tree formExpressionTree(String expression){
        Scanner input = new Scanner(expression);
        Stack<Node> stack = new Stack<Node>();

        while (input.hasNext()){
            String symbol = input.next();
            Node node = new Node(symbol);

            if (isOperator(symbol)) {
                node.right = stack.pop();
                node.left = stack.pop();
            }

            stack.push(node);
        }
        if(stack.size() != 1){
            throw new IllegalStateException("invalid stack");
        }

        Node rootNode = stack.pop();

        Tree tree = new Tree();
        tree.root = rootNode;
        return tree;
    }

    private static boolean isOperator(String symbol) {
        return "+-*".contains(symbol);
    }
}
