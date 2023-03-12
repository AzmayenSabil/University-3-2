.model small
.stack 100h

.data
    msg db 'The product of the first 6 terms: $'

.code
    main proc
        mov ax, @data
        mov ds, ax

        ; initialize variables
        mov cx, 6           ; number of terms
        mov al, 1           ; initial value of first term
        mov bh, 1           ; initial value of product

        ; loop to calculate product
        loop_start:
            mul bh          ; multiply current term with product
            add al, 2       ; increment term by 2
            dec cx          ; decrement loop counter
            jnz loop_start  ; loop until cx = 0

        ; display the result
        mov ah, 9
        lea dx, msg
        int 21h

        mov ah, 2
        mov dl, bh
        int 21h

        mov ax, 4c00h
        int 21h
    main endp
end main
