.model small
.stack 100h

.code

    main proc
    
        mov ah, 1 ; read first decimal digit
        int 21h
        mov bl, al ; store first decimal digit in bl
        sub bl, 30h
        
        mov ah, 2 ; newline
        mov dl, 0Ah
        int 21h
        mov dl, 0dh
        int 21h
        
        mov ah, 1 ; read second decimal digit
        int 21h
        add bh, al ; store second decimal digit in bl
        sub bh, 30h
        
        mov ah, 2 ; newline
        mov dl, 0Ah
        int 21h
        mov dl, 0dh
        int 21h
        
        add bl, bh
        add bl, 30h
        
        mov ah, 2   ; display
        mov dl, bl
        int 21h
        
        mov ah, 4Ch ; return to DOS
        int 21h
    
    main endp

end main

