import java.util.Scanner;
import java.lang.*;

public class Program {

    public static void main(String[] args) {
      System.out.print("time passed in ms: ");
      if (args[0].equals("str"))
        System.out.println(concatStr(Integer.valueOf(args[1])));
      else      
        System.out.println(concatBuilder(Integer.valueOf(args[1])));
    }

   public static long concatStr(int n) {
     long timeStart  = System.currentTimeMillis();
     String str = "";
     for (int i = 0; i < n; i++) {
       str += "a";
     }
     long timeEnd = System.currentTimeMillis();
     return timeEnd - timeStart;
   }
    
   public static long concatBuilder(int n) {
     long timeStart  = System.currentTimeMillis();
     StringBuilder str = new StringBuilder(); 
     for (int i = 0; i < n; i++) {
       str.append("a");
     }
     long timeEnd = System.currentTimeMillis();
     return timeEnd - timeStart;
   }

}
