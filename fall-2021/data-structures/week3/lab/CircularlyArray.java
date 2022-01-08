public class CircularlyArray {
  int array[];
  int size;
  
  public CircularlyArray(int capacity) {
    array = new int[capacity];
    size = 0;
  }

  public void insert(int i, int element) {
   // i = this.realIndex(i);
   // 1 2 _ _ _
    if (i < 0 || i > array.length || i > size)
      throw new ArrayIndexOutOfBoundsException(i); 
    // shift elements to right 
    if (i < size)
      shiftRight(i);
    this.array[i] = element;
    size++;
  }

  public void update(int i, int element) { 
    i = this.realIndex(i);
    if (i < 0 || i > array.length || i > size)
      throw new ArrayIndexOutOfBoundsException(i); 
    this.array[i] = element;
  }
  
  public int delete(int i) {
    if (i < 0 || i > array.length || i > size)
      throw new ArrayIndexOutOfBoundsException(i); 
    i = this.realIndex(i);
    int deleted = this.array[i]; 
    shiftLeft(i);
    size--;
    return deleted;
  }

  // 1 2 3 4 
  // 2 3 4 
  // get element i 
  public int get(int i) {
    i = this.realIndex(i); 
    return this.array[i];
  }

  @Override 
  public String toString() {
    StringBuilder elements = new StringBuilder();
    elements.append("[");
    for (int i = 0; i < this.size; i++) {
      elements.append(this.array[i]);
      if (i != size - 1)
        elements.append(", ");
    }
    elements.append("]");
    return elements.toString();
  }

  // helper methods
  private int realIndex(int i) {
    // prevent arithmetic exception
    if (i == 0)
      return 0;
    return i % this.size;
  }

  /* shift left side  one step starting starting from given index */
  public void shiftLeft(int index) {
    for (int i = index; i < this.size - 1; i++) 
      this.array[i] = this.array[i + 1];
  }

  /* shift right side  one step starting starting from given index */
  public void shiftRight(int index) {
    for (int i = this.array.length - 1; i > index; i--) 
      this.array[i] = this.array[i - 1];
  }

  public static void main(String[] args) {
    CircularlyArray numbers = new CircularlyArray(10); 
    for (int i = 0; i < 5; i++) {
        numbers.insert(i, i + 1);
    }
    System.out.println(numbers);
    numbers.delete(4);
    System.out.println(numbers);
  }

}








