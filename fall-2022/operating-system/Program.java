public class Program {

    public static void main(String[] args) {
        boolean condition =  false;
        while (condition);

        System.out.println("Hello, World!"); 


        // process i
        do { 
            while (turn == j); // wait other procress, 
                // critical section
            turn = j; // give turn to j
        } while (true);
    }


    /*
     *
     * Mutual Exclusion: Only one process can be in critical section (Mutex)
     * Progress: No process in critical section, one wish to enter, critical section cannot be posponed.     
     * Bounded Waiting:  
     *
     * Preemtive: allow process preemption   
     * Non-preemtive: runs until exits kernel mode 
     *  - No concurrency
     */






    /*
     *
     *
     *
     *
     *
     * int turn; // whose turn to enter critical section
     * Boolean flag[2]; // is process ready to enter its critical section
     * 
     *
     * process are nice, each gives 
     *
     *
     *
     *
     * 
     *
     */


    // Pi
    do { 
        flag[i] = true; // 
        turn = j;
        while (flag[j] && turn == j);
            // critical section
        flag[i] = false; // critical section executed
            // remainder section
    }

}
