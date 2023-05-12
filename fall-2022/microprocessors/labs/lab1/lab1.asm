; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h

; set SI 2000h
MOV SI, 2000h
        
MOV CX, N ; loop counter
MOV AX, 0 ; store total sum
MOV BX, 0 ; value to assign      
MOV DX, 1 ; use BX as counter      

loopstarts:            
    ; run this code N times           
    MOV [SI + BX], DX  ; assign value to memory 
    ADD AX, DX ; add to total 
    INC BX ; go to next address
    INC DX ; increment counter 
loop loopstarts

MOV [SI + BX], AX  ; assign value to memory    

ret
   
N DW 5

end           
      
