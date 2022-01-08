using System;

namespace HelloWorldApp {
    
  // Class declaration
  class Concat {
      
    // Main Method
    static void Main(string[] args) {
      for (int i = 0; i < 4; i++) {
        int n = (int)Math.Pow(10, i + 3); 
        if (i != 3)
          Console.Write(concat(n) + ",");
        else
          Console.WriteLine();
      }
    }

    static long concat(int n) {
      long start = DateTimeOffset.UtcNow.ToUnixTimeMilliseconds();
      string temp = "";
      for (int i = 0; i < n; i++) {
        temp = temp + "c";
      }
      long end =DateTimeOffset.UtcNow.ToUnixTimeMilliseconds();
      return end - start;
    }

  }

}


