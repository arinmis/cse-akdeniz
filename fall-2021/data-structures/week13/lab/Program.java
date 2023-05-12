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

public class Program {

    public static void main(String[] args) {
        // read string from file
        String inputStr = readFile("data.txt");

        // find freq
        HashMap<Character, Integer> freq = findFreq(inputStr);


        // create huffman tree
        Huffman huffman = new Huffman(freq.size());
        huffman.createTree(freq);
        huffman.(huffman.root, "");

        
        // print 
        System.out.println(replace(str, huffman.encoder));
         
    }

    public static String convert(String str) {
        String converted = str;
        int byteLen = (int)Math.ceil((double)converted.length() / 8); 
        return converted;
    }

    /* read string from file */
    public static String readFile(String path) {
        String result = "";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                result +=  myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not foud: " + path);
            e.printStackTrace();
        }
        return result;
    }

    public static String replace(String str, HashMap<Character, String> encoder) {
        String replaced = str;
        for (Map.Entry<Character, String> entry : encoder.entrySet())  {
            replaced = replaced.replaceAll(String.valueOf(entry.getKey()), entry.getValue()); 
        }
        return replaced;
    }

    /* find frequency of the given string's chars */
    public static HashMap<Character, Integer> findFreq(String str) {
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        for (char chr : str.toCharArray()) { 
            if (result.containsKey(chr))
                result.put(chr, result.get(chr) + 1);
            else 
                result.put(chr, 1);
        }
        return result;
    }

    /* print given hashmap */
    public static void  printMap(HashMap<Character, Integer> map) {
        System.out.println("*********** Map values ***********");
        for (Map.Entry<Character, Integer> entry : map.entrySet()) 
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        System.out.println("*********** Map values ***********");
    }





}
