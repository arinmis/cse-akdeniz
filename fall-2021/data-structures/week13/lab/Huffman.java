import java.io.*;
import java.util.*;

/*
 * Huffman encode with tree
 * to compress string data
 *
 * @author Mustafa Arinmis
 * @since 17.12.2021
 *
 */

public class Huffman  {

    PriorityQueue<Node> pq;
    Node root;
    HashMap<Character, String> encoder;

    public Huffman(int size) {
        pq = new PriorityQueue<>(size, new MyComparator());
        encoder = new HashMap<Character, String>();
    }

    public Huffman() {
        this(1);
    }

    /* inner node class */
    private class Node {
        int freq;
        char c;

        Node left, right;

        Node(char c, int freq) {
            this.freq = freq;
            this.c = c;
            left = null;
            right = null;
        }

        Node() {}

    }

    public void createTree(HashMap<Character, Integer> freq) {
        // put all of them to priority queueu
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            pq.add(node);
        }
        while (pq.size() > 1) {
            Node x = pq.poll();
            Node y = pq.poll();

            Node newNode = new Node();
            newNode.freq = x.freq + y.freq;
            newNode.c = '-';

            // assing pointers
            newNode.left = x;
            newNode.right = y;

            pq.add(newNode);
        }
        root = pq.peek();
    }

    /* traverse tree */
    public void traverse(Node node, String s) {
        if (node.left == null && node.right == null)  {
            //System.out.println(node.c + " : " + s);
            encoder.put(node.c, s);
            return;
        }
        traverse(node.left, s + '0');
        traverse(node.right, s + '1');
    }

    class MyComparator implements Comparator<Node> {

        @Override
        public int compare(Node x, Node y) {
            return x.freq - y.freq;
        }
    }

}
