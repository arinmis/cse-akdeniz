import java.io.*;
import java.util.*;

public class HW3_20190808004_1 {

    public static void main(String[] args) {
        // read tree nodes and x
        ArrayList<int[]> nums = readFile(args[0]);
        int[] treeValues = nums.get(0);
        // value x
        int pathSum = nums.get(1)[0];

        // create binary search tree
        /*
         *      20
         *  10      30

        */

        BTS  bts = new BTS();
        for (int value : new int[] {10, 5, 1, 7, 40, 50}) {
            bts.add(value);
        }
        bts.printTree();
        System.out.println();
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

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
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
                return;
            }
            insert(node.right, newNode);
        }
        else if (newNode.value < node.value) {
            // place new node to left 
            if (node.left == null) {
                node.left = newNode;
                return;
            }
            insert(node.left, newNode);
        }
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

}
