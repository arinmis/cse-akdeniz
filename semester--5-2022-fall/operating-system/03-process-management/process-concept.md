# Process Concept 
A batch system executes jobs, whearas a time-shared system ahs user programs, or tasks. 

## The Process
Informally, process is a program in execution. A process is more than code, those are the parts:  

- __Text section__: instruction to be executed
- __Program Counter__: Represent current activity 
- __Stack__: Stores temporary data such as function parameters, return addresses, and local variables. 
- __Data Section__: contains global variables 
- __Heap__: Memory that is dynamically allocated during process run time.

## Process State
Process may be in one the following states:
- New: the process is being created
- Running: instructions are being executed
- Waiting: the process is waiting for some event to occur(such as an I/O completion or reception of a signal).
- Ready: the process is waiting to be assigned to a processor
 - Terminated: the process has finished execution.

## Process Control Block
Each process is represented in the operating system by a __process control block(PCB)__, also called a task control block. It includes: 
- Process state: It have to one of the element in this set: {new, read, running, waiting, halted} 
- Program counter: An address of the next instruction to be executed.
- CPU registers: They include accumulators, index registers, stack pointers, and general-purpose registers etc. 
- CPU-scheduling information: Process priority, pointers to scheduling queues, and any other scheduling parameters.
- Memory-management information:   
- Accounting information: amount of CPU and real time used, time limits, account number, job or process numbers and so on.
- I/O status information: I/O devices allocated to the process, a list of open files, and so on. 


Before swithing to new process, PCB for the current process must be saved and the new one loads its state.

## Threads
Process is a program that performs a single thread of execution.
