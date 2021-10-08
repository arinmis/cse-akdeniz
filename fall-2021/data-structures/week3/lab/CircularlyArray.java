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
    // rotate elements to right 
    if (i < size)
      rotateRight(i);
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
    size--;
    return this.array[i];
  }

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
      return 1;
    return i % this.size;
  }

  public void rotateRight(int index) {
    // no rotation needed
    if (index == size - 1) {
      this.array[index + 1] = array[index]; 
      return;
    }
    int temp = this.array[index];
    for (int i = index; i < size; i++) {
      int prev = this.array[ i];  
      this.array[i] = temp; 
      temp = prev;
    }
    
  }

  public void rotateLeft(int index) {
    // no rotation needed
    if (index == size - 1) {
      this.array[index + 1] = array[index]; 
      return;
    }
    int temp = this.array[index];
    for (int i = index; i < size; i++) {
      int prev = this.array[ i];  
      this.array[i] = temp; 
      temp = prev;
    }
    
  }

  public static void main(String[] args) {
    CircularlyArray numbers = new CircularlyArray(10); 
    numbers.insert(0, 5);
    numbers.insert(1, 6);
    numbers.insert(1, 7);
    numbers.insert(3, 8);
    numbers.insert(4, 9);
    System.out.println(numbers);
  }



}
