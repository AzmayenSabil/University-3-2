INHEX PROC

    XOR BX,BX ; clear BX
    
    ;input character
    MOV CX,4
    MOV AH,1
    INT 21H
        
    LOOP1:
        ;check if inout is within 0 to 9
        CMP AL,0DH
        JE END1
        CMP AL,39H
        JG A_TO_F
        CMP AL, 30H
        JL A_TO_F
        
        AND AL,0FH
        JMP REPEAT1
        
    A_TO_F: ;check for input A to F
        SUB AL,37H
        
    REPEAT1:
        SHL BX,CL
        OR BL,AL
        INT 21H
        JMP LOOP1
        
    END1:
        RET
        
INHEX ENDP