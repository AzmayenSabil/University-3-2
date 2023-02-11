.model small
.stack 100h

.data
    a db '*******', 10, 13, '$'
    mid db '**$'

.code 

    main proc
        
        mov ax, @data
        mov ds, ax
        
        mov ah, 2
        mov dl, '?'
        int 21h
        
        mov ah, 1
        int 21h
        mov bl, al
        
        mov ah, 1
        int 21h
        mov bh, al
        
        mov ah, 1
        int 21h
        mov cl, al
       
        mov ah, 2
        mov dl, 0ah    ; newline
        int 21h
        mov dl, 0dh
        int 21h
        
        lea dx, a
        
        mov ah, 9
        int 21h
        int 21h
        int 21h
        
        mov ah, 9
        lea dx, mid
        int 21h
        
        mov ah, 2
        mov dl, bl
        int 21h
        
        mov ah, 2
        mov dl, bh
        int 21h
        
        mov ah, 2
        mov dl, cl
        int 21h   
        
        mov ah, 9
        lea dx, mid
        int 21h
        
        mov ah, 2
        mov dl, 0ah    ; newline
        int 21h
        mov dl, 0dh
        int 21h
        
        lea dx, a
        
        mov ah, 9
        int 21h
        int 21h
        int 21h
    
        mov ah, 2
        mov dl, 07h
        int 21h
    
        mov ah, 4Ch ; return to DOS
        int 21h
    
    main endp

end main
