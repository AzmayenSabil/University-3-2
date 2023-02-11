.model small
.stack 100h

.data
    input_message db 'Enter a hex digit: $'
    output_message db 'The decimal equivalent is: $'

.code 

    main proc
        
        mov ax, @data ; load data
        mov ds, ax     
            
        mov ah, 09 ; display input message
        lea dx, input_message
        int 21h
    
        mov ah, 1 ; read hex digit
        int 21h
        mov bh, al
        sub bh, 17d ; convert hex to dec
        
        mov ah, 2
        mov dl, 0ah    ; newline
        int 21h
        mov dl, 0dh
        int 21h
    
        mov ah, 09 ; display output message
        lea dx, output_message
        int 21h
        
        mov dl, 49d
        mov ah, 2
        int 21h
    
        mov dl,bh ; display result
        mov ah, 2
        int 21h
    
        mov ah, 4Ch ; return to DOS
        int 21h
    
    main endp

end main
