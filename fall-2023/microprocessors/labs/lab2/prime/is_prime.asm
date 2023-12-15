include 'emu8086.inc' ; import print

org 100h
CALL findIsPrime
CMP isPrime, 0
JNZ notPrime 
    PRINT 'Numer is prime'
    JMP exit
notPrime: 
    PRINT 'Numer is not prime'
exit:
RET  


findIsPrime PROC 
    MOV AX, 2
    CMP AX, number ; if number <= 2, not prime
    JG  exit      ; leave isPrime as not prime
           
    MOV CX, number  
    SUB CX, 2 ; calculate number of iteration 
    MOV BL, 2 ; use BX as factor 
    
    loopStarts:
        PUSH CX ; save loop counter at the stack
        MOV AX, number
        IDIV BL
        CMP AH, 0
        JNZ cantdivide 
            ; not prime detected
            LEA BX, isPrime
            MOV BYTE PTR [BX], 1
            POP CX ; pop the CX 
            JMP return
        cantdivide:
        POP CX
        INC BL
    LOOP loopStarts
    
    return:
    RET   
findIsPrime ENDP


number DW 19
isPrime DB 0
; 0 -> not prime
; 1 -> prime

END




