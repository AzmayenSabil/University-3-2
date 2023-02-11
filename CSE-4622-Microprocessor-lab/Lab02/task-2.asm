.model small
.stack 100h

.data
    b db 0 ; set value of B to 10

.code 

    main proc
        
        mov ax, @data ; loading the data
        mov b, 10d   ; setting the value of b
        
        mov ah, 2 ; display '?'
        mov dl, '?'
        int 21h
    
        mov ah, 1 ; read value of A
        int 21h
        sub al, 30h ; convert ASCII code to decimal
    
        mov bl, al
        mov al, 2
        mul bl     ; multiplying A with 2
        
        mov cl, al
        sub b, 1   ; subtracting 1 from b 
        sub b, cl  ; subtracting 2*A from b
    
        mov ah, 2
        mov dl, 0ah     ; newline
        int 21h
        mov dl, 0dh
        int 21h
    
        mov ah, 2 ; display result
        mov dl, b
        add dl, 30h
        int 21h
    
        mov ax, 4Ch ; return to DOS
        int 21h 
        
    main endp

end main
