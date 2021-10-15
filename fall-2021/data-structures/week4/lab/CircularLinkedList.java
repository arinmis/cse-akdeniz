/* 
 * Implementation of circulary linked list 
 * @author Mustafa Arinmis
 * @since 15.10.2021
**/

class CircularLinkedList<T> {

   static class Node<T> {
        private T value;
        private Node<T> next; 

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        // value getter and setter
        public T getValue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        // next getter and setter
        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }

        @Override 
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    // head 
    private Node<T> head;  
    private Node<T> tail;
    int size; 
    public CircularLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insert(int index, T value) {
        Node<T>  newNode = new Node<>(value);
        if (this.size == 0 ) {
            this.head = newNode;
            newNode.setNext(head);
        }
        else if(index == 0) {
            Node<T> temp = this.head;
            this.head = newNode;
            newNode.setNext(temp);
        }
        else{
            Node<T> indexNode = get(index - 1);
            this.addBetween(indexNode, indexNode.getNext(), newNode);
        }
        // increse size
        this.size++;
    }

    // update value of given index's node
    public void update(int index, T value) {
        Node<T> node = get(index);
        node.setValue(value);
    }

    // delete the given index
    public T delete(int index) {
        Node<T> preNode = get(index - 1);
        Node<T> deleted = preNode.getNext();
        if (index == 0) // when head deleted
            this.head = preNode.getNext().getNext(); 
        // perform deletion
        preNode.setNext(preNode.getNext().getNext());
        this.size--; // decrease the size
        return deleted.getValue();
    }


    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        this.addBetween(this.get(size - 1), head, newNode);
        this.head = newNode;
        size++;
    }
    
    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> preTail = this.get(size - 1);
        this.addBetween(preTail, preTail.getNext(), newNode);
        size++;
    }

    // 0 1 2 3
    public Node<T> get(int index) {
        // find correct index
        index %= this.size;
        if ( index < 0) 
            index += this.size;
        if (index < 0 || index > size) 
            throw new IndexOutOfBoundsException();
        Node<T> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        } 
        return temp;
    }

    // getter for head 
    public Node<T> getHead() {
        return this.head;
    }

    // helper method
    private void addBetween(Node<T> firstNode, Node<T> lastNode, Node<T> newNode) {
        firstNode.setNext(newNode);
        newNode.setNext(lastNode);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> temp = this.head;
        for (int i = 0; i < this.size; i++) {
            result.append(temp.getValue());
            if (i != this.size - 1) 
                result.append(", ");
            temp = temp.getNext();
        } 
        return result.toString();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> cl = new CircularLinkedList<>();
        for (int i = 0; i < 5; i++)
            cl.insert(i, i + 1);
        cl.addLast(99);
        cl.addLast(100);
        System.out.println(cl);
    }

}
