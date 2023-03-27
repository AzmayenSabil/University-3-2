.MODEL SMALL

.STACK 100h

.DATA
	hex1 DW ?
 	hex2 DW ?
 	
 	Prompt1 DB 'Type a HEX Number, 0 - FFEF: $'   ; input message 1
	Prompt2 DB 'Type a HEX Number, 0 - FFFF: $'   ; input message 2
    Prompt3 DB 10, 13, 'The SUM is: $'            ; output message 
    
	counter db 4 ; number of digits in a hexnumber
	
.CODE

MAIN PROC
    MOV AX, @DATA  ; loaded the data segment    
    MOV DS, AX

                       
    MOV AH,9
    LEA DX, Prompt1  ; first message print        
    INT 21h            
    
    CALL INHEX     ; called the inhex procedure     
    MOV hex1,BX    ; hex1 a BX rakhtesi     
       
    ;print Carraige return and new line                    
    MOV AH,2
    MOV DL,0DH
    INT 21H
    MOV AH,2
    MOV DL,0AH
    INT 21H
  

    MOV AH,9            
    LEA DX, Prompt2   ; same as before    
    INT 21h
    
                         
    CALL INHEX 
    MOV hex2,BX ; hex2 a BX rakhtesi
    
        
    MOV AH,9
    LEA DX, Prompt3
    INT 21h
 
    
                         
    ADD BX,hex1
     
	CALL OUTHEX  ; showign result = hex1 + hex2


MAIN ENDP


INHEX PROC                 
    XOR BX,BX  ; initialized zero            
    MOV CL,4               
    
                           
    MOV AH,1               
    INT 21H ; take the first input digit
    
Loop:                    
    CMP AL,0DH   ; comparing if it is CR or not          
    JE END1
    
    CMP AL,'9' ; digit or alphabet?                                                        
    JG Letter
    
    AND AL,0FH ; getting the hexa decimal value of digit            
    JMP SHIFT
    
Letter:                
    SUB AL,37H ; getting the hexa decimal value of letter
    
SHIFT:                     
    SHL BX,CL  ; shifting BX left by 4 bits            
    OR BL,AL   ; and putting the latest input in the most right section of BL
    
    INT 21H    ; taking the next input
    
    JMP Loop  
    
END1: 
    RET
    
INHEX ENDP   



                         
OUTHEX PROC
    
    MOV CL,4  ; 4 digits to show
                  
PRINT:                     
    MOV DL,BH   ; getting the BH(the righmost two digits) to store inside DL           
    SHR DL,CL   ; Then shifting right to display only one digit
                 
    CMP DL,9    ; comparing to see if its a digit or letter          
    JG  LETTER
              
    ADD DL,30H  ; number or digit           
    JMP DIGIT        

LETTER:                  
    ADD DL,37h  ; letter A,B,C,D,E,F
    
DIGIT:
    MOV AH,2               
    INT 21h
    
    ROL BX,CL  ; rotating the ans , ans = AE24 ---> E24A ---> 24AE            
    DEC counter
                
    CMP counter,0          
    JNE PRINT
                  
RET
                       
OUTHEX ENDP
    
    
    
END MAIN