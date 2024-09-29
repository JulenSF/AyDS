.data
nums: .word 5, 9, 2, 8, 1, 3, 6, 7, 4, 0
sorted: .space 40

.text
.globl main

main:

	la t0, nums
	la t1, sorted
	li t2, 10
	li t3, 0
	
copy_loop:

	beq t3, t2, sort_loop
	
	lw t4, 0(t0)
	sw t4, 0(t1)
	addi t0, t0, 4
	
	addi t1, t1, 4
	
	addi t3, t3, 1
	j copy_loop
	
sort_loop:
	li t5, 1
outer_loop:
	beq t5, zero, end_sort
	li t5, 0
	la t0 sorted
	li t3, 9
	
inner_loop:
	beq t3, zero, outer_loop
	
	lw t6, 0(t0)
	lw t2, 4(t0)
	
	ble t6, t2, no_swap
	
	sw t2, 0(t0)
	sw t6, 4(t0)
	li t5, 1
no_swap:
	addi t0, t0, 4
	addi t3, t3, -1
	j inner_loop
end_sort:
	li a7, 10
	ecall
	