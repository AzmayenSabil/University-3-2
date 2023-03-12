OUTHEX PROC
    
      MOV COUNT,0
      
      LOOP2:
        
        ;seperate digits
        MOV CX,0
        MOV DL,BH
        MOV CL,4
        SHR DL,CL
        
        ;display digits    
        CMP DL,9
        JG SHOW_A_TO_F
        ADD DL,48D
        JMP OUTPUT
        
        SHOW_A_TO_F: ;display A to F
            ADD DL,55D
            JMP OUTPUT
            
        OUTPUT:
            MOV AH,2
            INT 21H
            
        INC COUNT
        CMP COUNT,4
        JGE END2
        MOV CL,4
        ROL BX,CL
        JMP LOOP2
        
    END2:
        RET
        
OUTHEX ENDP