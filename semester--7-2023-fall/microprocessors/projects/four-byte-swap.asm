org 100h  
    MOV CX, 2
    MOV BX, 2000h
    MOV SI, 0
    MOV DI, 4  
    SWAP:
        MOV Ax, [BX + SI]
        MOV DX, [BX + DI]
        MOV [BX + DI], AL
        MOV [BX + SI], DX
        
        ADD SI, 2
        ADD DI, 2
    LOOP SWAP
ret
