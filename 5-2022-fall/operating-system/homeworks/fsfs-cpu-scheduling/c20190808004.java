import java.util.ArrayList;
import java.util.Arrays;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
 import java.util.Collections;

public class c20190808004 { 

    public static void main(String[] args) { 
        int cpuTime = 0;
        int idleProcessCount = -1; // to balance last process, it starts from 0
        ArrayList<Process> readyQueue = readProcesses(args[0]);
        ArrayList<Process> waitQueue = new ArrayList<Process>();
        ArrayList<Process> terminatedProcesses = new ArrayList<Process>();
        Process runningProcess = null;  //  




        /* keep track of stats */
        /* increase cpuTime while there are none-terminated processes */   
        while (readyQueue.size() != 0 || waitQueue.size() != 0 || runningProcess != null) { 

            // handle IO bursts
            for (int i = 0; i < waitQueue.size(); i++) {
                int ioBurst = waitQueue.get(i).burstPairs.get(0)[1];
                if (ioBurst == -1) { // terminate the process
                    Process terminated = waitQueue.remove(i);
                    terminated.turnAroundTime = cpuTime; // record turn around time
                    terminatedProcesses.add(terminated);
                    i--;
                } 
                else if (ioBurst == 0) { // put process ready queue
                    waitQueue.get(i).burstPairs.remove(0); // remove handled burst pair
                    readyQueue.add(waitQueue.remove(i));
                    i--;
                }
                else {
                    waitQueue.get(i).burstPairs.get(0)[1]--;
                }
            }


            // pull process to running state 
            if (readyQueue.size() != 0 && runningProcess == null) {
                runningProcess = readyQueue.remove(0);
            }
            if (runningProcess != null) { // proccess if there is running 
                // no CPU burst, put process waiting queue 
                if (runningProcess.burstPairs.get(0)[0] == 1) { 
                    waitQueue.add(runningProcess);
                    if (readyQueue.size() > 0) { 
                        runningProcess = readyQueue.remove(0);
                    } else {
                        runningProcess = null; // assign idle process
                        idleProcessCount++;
                    }
                }
                else {
                    runningProcess.burstPairs.get(0)[0]--; // descrease cpu burst
                }
            }

            cpuTime++; // increase CPU time
        }
        double avgTurnAround = findAvgTurnAround(terminatedProcesses);
        double avgWaitingTime = findAvgWaiting(terminatedProcesses);
        System.out.printf("Average turnaround time: %.2f\n", avgTurnAround);
        System.out.printf("Average waiting time: %.2f\n",avgWaitingTime);
        System.out.printf("The number of times that the IDLE process executed: %d\n", idleProcessCount);
        System.out.println("HALT");
    }

    public static double findAvgTurnAround(ArrayList<Process> processes) {
        int total = 0;
        for (Process process : processes)
            total += process.turnAroundTime;
        return (double)total / processes.size();

    }

    public static double findAvgWaiting(ArrayList<Process> processes) {
        int total = 0;
        for (Process process : processes)
            total += process.calcWaitingTime();
        return (double)total / processes.size();
    }

    /* reads processes from file, and return them in a list */
    public static ArrayList<Process> readProcesses(String filename) {
        ArrayList<Process> processes = new ArrayList<Process>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] processData = myReader.nextLine().split(":");
                String[] burstPairs = processData[1].split(";"); 
                ArrayList<int[]> burstPairList = new ArrayList<int[]>();
                for (String burstPair : burstPairs) {
                    String[] cpuAndIOBurst = burstPair.substring(1, burstPair.length() - 1).split(",");
                    int cpuBurst = Integer.parseInt(cpuAndIOBurst[0]);
                    int ioBurst = Integer.parseInt(cpuAndIOBurst[1]);
                    burstPairList.add(new int[] {cpuBurst, ioBurst});
                }
                Process newProcess = new Process(Integer.parseInt(processData[0]), burstPairList);
                processes.add(newProcess);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            e.printStackTrace();
        }
        Collections.sort(processes); // sort Processes by id
        return processes;
    }
}


/* represent each process with id, and CPU and IO burst pairs */
class Process implements Comparable<Process> {
    public int id;
    public ArrayList<int[]> burstPairs; 
    public ArrayList<int[]> initBurstPairs; 
    public int turnAroundTime;

    public Process (int id, ArrayList<int[]> burstPairs) { 
        this.id = id;
        this.burstPairs = burstPairs; 
        this.initBurstPairs = copyBurstPairs(burstPairs);
        int turnAroundTime = 0;
        int waitingTime = 0;
    }

    public ArrayList<int[]> copyBurstPairs(ArrayList<int[]> burstPairs) { 
        ArrayList<int[]> copy = new ArrayList<int[]>();
        for (int [] burstPair : burstPairs)
            copy.add(new int[] {burstPair[0], burstPair[0]});
        return copy;
    }

    public void addBurst(int[] burst) { 
        burstPairs.add(burst);
    }

    /* waiting time = turn around time - total cpu burst */ 
    public int calcWaitingTime() { 
        return turnAroundTime - getTotalCPUBurst(); 
    }

    private int getTotalCPUBurst() {
        int total = 0;
        for (int[] burstPair : initBurstPairs)
            total += burstPair[0];
        return total;
    }

    @Override
    public String toString() { 
        String str = id  + ": ";
        for (int[] burstPair : burstPairs)   
            str += Arrays.toString(burstPair);
        return str;
    }

    @Override
    public int compareTo(Process otherProcess) {
        return this.id - otherProcess.id;
    }
}
