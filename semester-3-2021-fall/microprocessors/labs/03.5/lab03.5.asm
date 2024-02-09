ORG 100H

; divident % divisor = reminder
MOV AX, num1  ; divident
MOV BX, num2  ; divisor

gcdLoop:
    DIV BX
    MOV AX, BX ;update divident with divisor
    MOV BX, DX ;update divisor with reminder
    CMP DX, 0
    JE break
    MOV DX, 0
JMP gcdLoop
break:
  
MOV gcd, AX

RET
num1 DW 128
num2 DW 72
gcd DW 0
