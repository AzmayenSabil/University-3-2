.MODEL SMALL
.STACK 100H
.DATA
    PROMPT1 DB 'ENTER 6 TEMPERATURE IN FARENHEIT (0-255): $'
    PROMPT2 DB 'LARGEST NUMBER IN ARRAY: $'
    PROMPT3 DB 'LARGEST NUMBER INHEXADECIMAL: $'
    ARRAY DW 6 DUP(?)
    CR DB 0DH    
    COUNT DB ?
    LF DB 0AH
    MAX DW ?
.CODE
    MAIN PROC
        MOV AX,@DATA
        MOV DS,AX 
        
        LEA DX,PROMPT1
        MOV AH,9
        INT 21H
        
        XOR BX,BX
        LEA BX,ARRAY
        MOV CX,6 
        
        ;INPUT ARRAY          
        REPEAT1: 
            MOV AH,2
            MOV DL,CR
            INT 21H
            MOV DL,LF
            INT 21H
                     
            CALL INDEC
            MOV [BX],AX
            ADD BX,2           
            
            LOOP REPEAT1
            
        XOR BX,BX
        MOV CX,6 
        MOV MAX,0 ;MAX=0
        
        ;OUTPUT MAX
        REPEAT2:
            MOV AX,ARRAY[BX] ; STORE THE VALUE OF ARRAYAX
            CMP AX,MAX ; MAX>AX?
            JNG NEXT_INDEX  ; NO THEN GO TO NEXT INDEX
            MOV MAX,AX ; ELSE, MAX=AX
            NEXT_INDEX:
                ADD BX,2 ;GO TO NEXT INDEX
            LOOP REPEAT2
        
        MOV AH,2
        MOV DL,CR
        INT 21H
        MOV DL,LF
        INT 21H
        
        MOV AX, MAX ;STORES MAX IN AX
        
        MOV BX,MAX
        TEST MAX,1
        
        JZ EVEN
        LEA DX,PROMPT2
        MOV AH,9
        INT 21H
        
        ;LINE BREAK
        MOV AH,2
        MOV DL,CR
        INT 21H
        MOV DL,LF
        INT 21H 
        
        MOV AX, MAX ;STORES MAX IN AX   
        CALL OUTDEC
        JMP EXIT
        
        EVEN:
            LEA DX,PROMPT3
            MOV AH,9
            INT 21H
            CALL OUTHEX
            JMP EXIT
            
        EXIT:
            MOV AH,4CH
            INT 21H
            
    MAIN ENDP 
    
    INCLUDE D:\3-2 semester\micro lab\INDEC.ASM
    INCLUDE D:\3-2 semester\micro lab\OUTDEC.ASM
    INCLUDE D:\3-2 semester\micro lab\INHEX.ASM
    INCLUDE D:\3-2 semester\micro lab\OUTHEX.ASM 
    
END MAIN