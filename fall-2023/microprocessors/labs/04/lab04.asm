ORG 100h

; throw error: should be between 14 < N < 26
MOV CL, n
                                             
; check for error
CMP CL, 14
JLE error 
CMP CL, 26
JGE error
JMP noError

error:
CALL showError 
JMP exit
noError:
 
SUB CL, 2
MOV BL, 2

LEA SI, array  
; handle first two case
MOV [SI], 0  
INC SI
MOV [SI], 1
INC SI

myLoop:
    SUB SI, 2
    MOV DH, [SI] ; Fn-2
    INC SI
    MOV DL, [SI] ; Fn-1
    INC SI
    MOV AL, BL
    PUSH BX
    MOV BL, 2
    DIV BL
    POP BX
    CMP AH, 0
    JE even
        ; index is odd
        ADD DL, DH
        JMP odd
    even: 
        ; index is even 
        SUB DL, DH             
    odd:
    MOV [SI], DL    
    INC BL 
    INC SI
LOOP myLoop

exit:
RET 
n EQU 20     
array DB n DUP(5)
errorMsg DB 'Please enter a value between 14 and 26', 0 ; The message 

showError PROC 
    LEA SI, errorMsg ; Load the address of the message into SI
    MOV CX, 38       ; Set the counter to the length of the message
    MOV AH, 0Eh      ; Set up the BIOS teletype function

    GO: LODSB        ; Load the next character of the message into AL
    INT 10h          ; Print the character in AL to the screen
    LOOP GO          ; Loop back to print the next character
showError ENDP
