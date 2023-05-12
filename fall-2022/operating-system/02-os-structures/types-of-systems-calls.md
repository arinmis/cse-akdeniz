# Types of System Calls
There are 6 major categories:
    * process control
    * file manipulation
    * device manipulation
    * information maintenance
    * communications
    * protection

## Process Control
Running program needs to be halt its execution with normally (end()) or abnormally(abort())  
- end, abort
- load, execute
- create process, terminate process
- get process attributes, set process attributes
- wait for time
- wait event, signal event
- allocate and free memory


- Unix process control system calls: 
```
fork()
exit()
wait()
```
## File Managment
- OS can create and delete files, read, write and reposition operations are also supported.
## Device Managment
## Information Maintenance 
## Communication
There are two types of interprocess communication: message passing and shared-memory 
## Protection
