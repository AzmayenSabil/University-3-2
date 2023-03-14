.MODEL SMALL
.STACK 100h

.DATA
  start db 1d   ; start of sequence     
  ans dw 0d ; answer will be stored here
  
.CODE
 MAIN PROC
                     
   MOV AX,@DATA ; load the data segment 
   MOV DS,AX
   
   MOV CX,6   ; counter == 6        
   MOV AX,1d  ; It will be multiplied        
      
   LOOP_START:
    MUL start ; AX = AX*START    
    ADD start,2 ; start = start + 2                    
    MOV ans,AX  ; AX will be stored in ans
    
    LOOP LOOP_START ; loop until CX == 0
   
   MOV DX,ans   
   
   MOV AH, 4Ch     
   INT 21h
   
   MAIN ENDP
 END MAIN