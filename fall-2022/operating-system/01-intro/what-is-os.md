# Introduction
A program that manages a computer's hardware. Acts as an intermediary between the computer user and the computer hardware.  

Computer systems can be divided into four components: 

1. Hardware  
2. OS
3. Application Programs
4. Users   

## User View
Ease of use, resource utilization

## System View
- Allocates resource
- Control I/O operations


## Definition of OS
The operating system is the one program running at all times on the computer, called kernel.  

System programs associated with kernel but not nessarily part of the kernel.

# Computer System Organization
When computer is powered up initial program runs called _bootstrap program_. Bootstrap programs stored in _ROM_. Rom store and run firmware.

- With _interrupts_, CPU stops what it is doing.

## Storage Structure
- CPU load instructions only from memory. Most of the computers uses RAM's.

- On _von Neumann architecture_  execution cycle, instruction first fetches, decoded and executed.

- RAM is volatie, so we havesecondary storage. 
- Storage devices: 
    * In terms of data access speed:
        - register > cache >  main memory > ssd > magnetic disk > optical disk > magnetic tapes
    * In terms of cost:
        - register > cache >  main memory > ssd > magnetic disk > optical disk > magnetic tapes
    * In terms of size:
        - register < cache <  main memory < ssd < magnetic disk < optical disk < magnetic tapes

## I/O Structure
- Storage is one of the I/O.
- Direct memory access(DMA)  allow hardware(expcept CPU) main system memory independent from CPU. 

# Computer System Architecture
CPU(inclueded cache), memory and I/O device are main 3 components. 

## Single-Processor Systems
There is one main CPU capable of executing a general-purpose instruction set.
## Multiprocessor Systems
- Also known as parallel systems or multicore systems.
- Has 3 main advantage: 
    1. Increased throughput    
    2. Economy of scale
    3. Increase reliability: failure of one process does not halt the system.

- __Asymmetric multiprocessing__: Each processor is assigned a specific task. Boss processor schedules and allocaates work to the worker processors. 

- __Symmetric multiprocessing(SMP)__: All processor performs all tasks within the operating system. 

- __Multicore__: CPU that include multiple computing *cores* on a single chip. It is faster because of _on chip_ communication.  
While all multicore are multiprocessors, not all multiprocessors are multicore.   

## Clustered Systems
Parallelization divides a program into seperate components that run in parallel on individual computers in the cluster.

# Operating-Systems Structure
Single user can run multiple program at the same time. __Multiprogramming__ increase CPU utilization by organizing jobs(code and data) so that the CPU always has one to execute.  

Jobs are kept in on the disk in the __job pool__. Job pool consists of all processes residing on disk awaiting allocation fo main memory.  

__Time sharing__ is how multitasking is working.  

__Process__ is a program loaded into memory and executing is called a process.

__Swapping__ ensure reasonable response time.  

__Virtual Memory__ another method to ensure reasonable response time. Allow execution of process that is not in the memory. 

# Operating-System Operations
Modern operating systems are *interrupt driven*. Events signaled by the occurrence of an interrupt or a trap. A __trap__ (or an __exception__) is a software-generated interrupt caused by error(division by zero).  

## Dual-Mode and MUltimode Operatoin
We must distinguish between the execution of operating-system code and user defined code.  
We need two modes of operation:
    * user mode
    * kernel mode
__Priviliged instructions__ only can be executed in kernel mode. The instruction to switch to kernel mode is an example of a privileged instruction.  

__Systems calls__ is a question use ask to the operating system to perform taks. Systems calls are treated by the hardware as a software interrupt. 

## Timer
We cannot allow a user program to get stuck in an infinte loop or fail to call system services and never return controlback to the operating system. A timer can be set to interrupt the computer after a specified period.

# Process Managment
A program does nothing untill executed. Program being executed is called process.
    - A Single-threaded process has one *program counter* specifying the next instruction to execute.  
    Responsibilities of OS:
    - Scheduling processes and threads on the CPUs
    - Createing and deleteing both user and system processes
    - Suspending and resming processes
    - Providing mechanisms for process synchronization
    - Providing mechanisms communication

# Memory Managment
Memory is a large array of bytes. Some of the OS responsibilities for memory:
- Keeping track of which parts of memory are currently being used and who is using them
- Deciding which processes and data to move into and out of memory
- Allocating and deallocating memroy space needed

# Storage Managment
OS abstracts from the physical properties of its storage devices to define a logical storage unit, the __file__.

## File-Sytem Managment
- Files stored on mass storage.
- Creating and deleting files
- Creating and deleting directories o organize files.
- Supporting primitives for manipulating files and directories.
- Mapping files onto secondary storage
- Backing up files on stable(nonvolatile) storage media.

## Mass-Storage Managment
Programs like compilers, assemblers or word processors are stored on a disk until loaded into memory. 

## Caching
Information stored in main memory is copied into a faster storage system on a temporary basis.   
In multiprocessor environment cached values have to consisted and it is called __cache coherency__.

## I/O Systems
It hides the peculiarities of specific hardware devices from the user.
## Protection and Security
## Kernel Data Structure
### List, Stacks, and Queues
- Singly linked list has two part: data and pointer
- Stack: LIFO, OS uses stack when invoking function calls.
- Queue: FIFO, jobs sent to a printer with queueue data stucture. 
### Trees  
Parent-child relationship exists. Binary tree has a most two children and obeys the rule that leftChild < rightChild.  
### Hash Functions and Maps 
A hash function takes data as its input, performs a numberic operation on this data, and returns a numeric value.  
__Hash collision__ is the biggest issue about hashmap.

### Bitmaps 
String of _n_ binary digits that can be used to represent the status of _n_ items. We can represent the availability of 8 resourses with one byte like `10110001` and it takes only 1 byte instead of 8 byte. 

## Computing Evironment
### Mobile Computing
- Apple IOS
- Google Android
### Distributed Systems
### Client-Server Computing
### P2P Computring
### Virtualization
That allows operating systems to run as application within other operating systems.  
__Emulation__: It is used when the source CPU type is different than target CPU type. 
### Cloud Computing
Cloud computing is a type of computing that delivers computing, storage,
and even applications as a service across a network.  
Private cloud, Hybrid cloud, Saas, PaaS and IaaS.
### Real-Time Embedded Systems

## Open-Source Operating Sytems
### History
### Linux
### BSD UNIX
### Solaris
### Open-Source Systems as Learning Tools

## Summary
An operating system is software that manages the computer hardware, as well as providing an environment ofr application programs to run.
