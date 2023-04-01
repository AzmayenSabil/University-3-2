.MODEL SMALL
.STACK 100H
.DATA
    MSG1 DB 'ENTER 6 TEMPERATURE IN FARENHEIT (0-255): $'
    MSG2 DB 'TEMPERATURE SUMMATION IN CELSIUS: $'
    NUM1 DW ?
    NUM2 DW 0
 
.CODE 

    MAIN PROC
        
        MOV AX,@DATA  ; loading data
        MOV DS,AX 
        
        LEA DX,MSG1   ; showing the first message
        MOV AH,9
        INT 21H
        
        MOV CX,6  ; counter = 6
        
        ;sum of all inputs
                
        SUMMATION:
            MOV AH,2
            MOV DL,0DH
            INT 21H
            MOV DL,0AH
            INT 21H 
                     
            CALL INDEC  ; calling the input function
            ADD NUM1,AX ;STORE INPUT IN NUM1 
            
            LOOP SUMMATION
        
        MOV AX,NUM1
         
        SUB AX,32      ; F to C calculation
        MOV BX,5 
        MUL BX 
        MOV BX,9 .
        DIV BX 
        MOV NUM1, AX
        
        MOV AH,2
        MOV DL,0DH
        INT 21H        ; new line
        MOV DL,0AH
        INT 21H
        
        
        LEA DX,MSG2
        MOV AH,9       ; showing the second message
        INT 21H
        
        MOV AH,2
        MOV DL,0DH
        INT 21H         ; new line
        MOV DL,0AH
        INT 21H 
        
        MOV AX,NUM1    ; calling the output function
        CALL OUTDEC
        
        
        MOV AH,4CH
        INT 21H
        
    MAIN ENDP
        
    
    INCLUDE E:\Github Repo\University-3-2\CSE-4622-Microprocessor-lab\Lab04\INDEC.ASM
    INCLUDE E:\Github Repo\University-3-2\CSE-4622-Microprocessor-lab\Lab04\OUTDEC.ASM  
    


    
END MAIN