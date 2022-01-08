public class Concat {

  public static void main(String[] args) {
    for (int i = 0; i < 4; i++) {
      // measure concat time 
      int n = (int)Math.pow(10, i + 3);
      long time = concat(n);
      // print the result  
      System.out.print(time);
      if (i != 3)
        System.out.print(",");
      else
        System.out.println();
    }
  }

  public static long concat(int n) {
    long start = System.currentTimeMillis();
    String temp = ""; 
    for (int i = 0; i < n; i++) 
      temp += "c";
    temp += "c";
    long end = System.currentTimeMillis();
    return end - start;
  }

}
