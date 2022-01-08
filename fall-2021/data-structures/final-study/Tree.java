import java.io.*;
import java.util.*;

public class Tree {

    public static void main(String[] args) {
        // read tree nodes and x
        if (args.length != 1) {
            throw new IllegalArgumentException("give file as argument");
        }
        ArrayList<int[]> nums = readFile(args[0]);
        int[] treeValues = nums.get(0);
        // create and construct binary search tree
        BTS  bts = new BTS();
        for (int value : treeValues) {
            bts.add(value);
        }
        // print whether tree is balanced or not
        //System.out.println(bts.isBalanced());
        bts.mirror(bts.root);
        bts.printTree();

    }

    /* read string from file */
    public static ArrayList<int[]> readFile(String path) {
        ArrayList<int[]> result = new ArrayList<>(2);
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                result.add(getNumbers(line)); // convert line to int array
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not foud: " + path);
            e.printStackTrace();
        }
        return result;
    }

    /* convert spaced line string to number array */
    public static int[] getNumbers(String line) {
        String[] asStr = line.split(" ");
        int[] numbers = new int[asStr.length];
        for (int i = 0; i < asStr.length; i++) {
            numbers[i] = Integer.valueOf(asStr[i]);
        }
        return numbers;
    }

}

class BTS {

    // inner node class
    class Node {

        int value;
        Node left, right;
        Node parent;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
            parent = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }

    }

    Node root;

    BTS() {
        root = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        // when tree is empty
        if (this.root == null)
            this.root = newNode;
        // call recursive add method
        insert(this.root, newNode);
    }

    /* add new value to binary search tree */
    public void insert(Node node, Node newNode) {
        if (newNode.value > node.value) {
            // place new node to right
            if (node.right == null) {
                node.right = newNode;
                newNode.parent = node;
                return;
            }
            insert(node.right, newNode);
        }
        else if (newNode.value < node.value) {
            // place new node to left
            if (node.left == null) {
                node.left = newNode;
                newNode.parent = node;
                return;
            }
            insert(node.left, newNode);
        }
    }

    /* find the depth of the node */
    public int depth(Node node) {
        if (node.equals(this.root))
            return 0;
        return 1 + depth(node.parent);
    }

    /* find the height of the given tree */
    public int height(Node node) {
        int h = 1;
        if (node == null)
            return 0;
        if (node.left != null)
            h = Math.max(h, 1 + height(node.left));
        if (node.right != null)
            h = Math.max(h, 1 + height(node.right));
        return h;
    }

    /* determine whether tree is balanced or not */
    public boolean isBalanced() {
        // store result in array
        // to use same boolean data, in other scope
        boolean[] result = {true};
        balanceCheck(this.root, result);
        return result[0];
    }


    /* determine whether tree is balanced or not */
    public void balanceCheck(Node node, boolean[] result) {
        int heightLeft = height(node.left);
        int heightRight = height(node.right);
        if (Math.abs(heightLeft - heightRight) > 1) {
            result[0] = false;
        }
        if (node.left != null)
            balanceCheck(node.left, result);
        if (node.right != null)
            balanceCheck(node.right, result);
    }

    /* print tree with inorder treversal */
    public void printTree() {
        this.inorder(this.root);
    }

    /* recursive inoder traversal */
    public void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    /* mirror the given tree */
    public void mirror(Node node) {
        if (node != null) {

            // swap the siblings
            Node temp = root.left;
            root.left = root.right; 
            root.right = temp;
            mirror(node.left);
            mirror(node.right);
        }
    }

}
