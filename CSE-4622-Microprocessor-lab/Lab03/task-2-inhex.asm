INHEX PROC
    XOR BX, BX      ; Clear BX
    MOV CX, 4       ; Loop for 4 characters
    LOOP1:
        MOV AH, 1   ; Input a character
        INT 21H
        CMP AL, 0DH ; Check if input is carriage return
        JE END1
        CMP AL, 39H ; Check if input is between '0' and '9'
        JG A_TO_F
        CMP AL, 30H
        JL A_TO_F
        AND AL, 0FH ; Convert ASCII to hex digit
        JMP REPEAT1
    A_TO_F:
        SUB AL, 37H ; Convert ASCII to hex digit
    REPEAT1:
        SHL BX, 4   ; Shift existing digits to left
        OR BL, AL   ; Add new digit
        LOOP LOOP1
    END1:
        RET
INHEX ENDP
