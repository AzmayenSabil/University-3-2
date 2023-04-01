.MODEL SMALL
.STACK 100H
.DATA
    MSG1 DB 'ENTER 6 TEMPERATURE IN FARENHEIT (0-255): $'
    MSG2 DB 'ARRAY: $'
    
    ARRAY DW 6 DUP(?) ; DUP means duplicate  
    
.CODE       

    MAIN PROC
        MOV AX,@DATA 
        MOV DS,AX  ; Load the data
        
        ;INPUT ARRAY
        LEA DX,MSG1
        MOV AH,9
        INT 21H 
        
        XOR BX,BX
        LEA BX,ARRAY
        MOV CX,6
        
        ;INPUT         
        REPEAT1:
            ;LINE BREAK
            MOV AH,2
            MOV DL,0DH
            INT 21H
            MOV DL,0AH
            INT 21H 
                     
            CALL INDEC
            MOV [BX],AX ; STORE VALUE IN ARRAY INDEX
            ADD BX,2 
            
            LOOP REPEAT1    
            
        MOV AH,2
        MOV DL,0DH
        INT 21H
        MOV DL,0AH
        INT 21H
            
        LEA DX,MSG2
        MOV AH,9
        INT 21H
        
        MOV CX,6
        LEA BX,ARRAY
        
        ;OUTPUT 
        REPEAT2:
            ;LINE BREAK
            MOV AH,2
            MOV DL,0DH
            INT 21H
            MOV DL,0AH
            INT 21H
            
            MOV AX,[BX] ; STORE VALUE IN AX
            CALL OUTDEC
            ADD BX,2
            
            LOOP REPEAT2
        
        
        MOV AH,4CH
        INT 21H
            
    MAIN ENDP 
    
    INCLUDE E:\Github Repo\University-3-2\CSE-4622-Microprocessor-lab\Lab04\INDEC.ASM
    INCLUDE E:\Github Repo\University-3-2\CSE-4622-Microprocessor-lab\Lab04\OUTDEC.ASM 
   
END MAIN