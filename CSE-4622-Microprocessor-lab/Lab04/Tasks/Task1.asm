.MODEL SMALL
.STACK 100H
.DATA
    PROMPT1 DB 'Enter Temperature in Fahrenheit (0 to 255): $'
    PROMPT2 DB 'CELSIUS: $' 
    NUM1 DW ?
    

.CODE
    MAIN PROC
        
        MOV AX,@DATA ; Loading data
        MOV DS,AX 

        LEA DX,PROMPT1 ;First input message
        MOV AH,9 
        INT 21H        
 
        CALL INDEC      ;  Calling INDEC
        MOV NUM1,AX     
 
        SUB AX,32         
        MOV BX,5                     
        MUL BX         ; Calculating the value from the formula    
        MOV BX,9         
        DIV BX            
        MOV NUM1, AX      
        
        MOV AH,2     
        MOV DL,0DH   ; new line  
        INT 21H
        MOV DL,0AH   
        INT 21H

        LEA DX,PROMPT2     ; Output message
        MOV AH,9
        INT 21H 
        MOV AX,NUM1

        CALL OUTDEC         ; Calling OUTDEC
        
        MOV AH,4CH
        INT 21H
        
    MAIN ENDP
    
    INCLUDE E:\Github Repo\University-3-2\CSE-4622-Microprocessor-lab\Lab04\INDEC.ASM
    INCLUDE E:\Github Repo\University-3-2\CSE-4622-Microprocessor-lab\Lab04\OUTDEC.ASM
    
    END MAIN