.MODEL SMALL
.STACK 100h

.DATA
	hex1 DW ?
 	hex2 DW ?
	Prompt1 DB 'Type a HEX Number, 0 - FFFF: $'   ; instruction msg
    Prompt2 DB 10, 13, 'The SUM is: $'            ; instruction msg 2
	Prompt3 DB 'Type a HEX Number, 0 - FFEF: $', 10, 13   ; instruction msg 3
	counter db 4
	
.CODE
MAIN PROC
    MOV AX, @DATA      
    MOV DS, AX
                       
    MOV AH,9
    LEA DX, Prompt3         
    INT 21h            
    
    CALL INHEX          
    MOV hex1,BX         
       
    ;print Carraige return and new line                    
    MOV AH,2
    MOV DL,0DH
    INT 21H
    MOV AH,2
    MOV DL,0AH
    INT 21H

    MOV AH,9            
    LEA DX, Prompt1       
    INT 21h
                         
    CALL INHEX 
    MOV hex2,BX    
    MOV AH,9
    LEA DX, Prompt2
    INT 21h
 
    ADD BX,hex1 
	CALL OUTHEX  


MAIN ENDP


INHEX PROC                 
    XOR BX,BX              
    MOV CL,4               
    
    MOV AH,1               
    INT 21H
    
    Loop:                    
        CMP AL,0DH             
        JE END1
        CMP AL,'9'             
        JG Letter
        AND AL,0FH             
        JMP SHIFT
    
        Letter:                
            SUB AL,37H
        SHIFT:                     
            SHL BX,CL              
            OR BL,AL
            INT 21H
            JMP Loop
            
        END1: 
            RET
        
INHEX ENDP   

                         
OUTHEX PROC
    MOV CL,4              
    PRINT:                     
        MOV DL,BH              
        SHR DL,CL             
        CMP DL,9              
        JG  SHOW          
        ADD DL,30H             
        JMP DIGIT        

    SHOW:                  
        ADD DL,37h
        
    DIGIT:
        MOV AH,2               
        INT 21h
        ROL BX,CL              
        DEC counter            
        CMP counter,0          
        JNE PRINT
        
    RET
    
OUTHEX ENDP
    
END MAIN