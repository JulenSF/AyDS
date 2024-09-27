.data
init:	.word	10 2, 1, 5, 6, 3, 4, 10, 7, 9, 8
end:	.word	10 dup 0
aux:	.word	 0  
i:	.word	10
k:	.word	0
.text
main:
	lw t0,init
	lw t1, k
	lw t2, i
	for2:	
	for1:
		jle t0(t1), t0(t1+1), if
		lw aux, t0(t1+1)
		lw t0(t1+1), t0(t1) 
		lw t0(t1), aux
	 	if:
	 addi t1, t1, 1
	 jle t1, t2-1, for1	
	 addi t2, t2, -1
	 jge t2, 1, for2
	 lw t1, end
	 lw t2, 0
	 for3:
	 	lw t1(t2), t0(t2)
	 	addi t2, t2, 1
	 	bne t2, 10, for3 