import java.util.*;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);

    ListIterator<Integer> iter = numbers.listIterator();
    while (iter.hasNext()) {
        Integer variable = iter.next();
        if (variable == 1)
            iter.add(-1);
        System.out.println(variable);
    }

    for (int number : numbers) {
        System.out.println(number);
    }

  }
}

