#	Computer Systems Organization
#	Winter Semester 2021-2022
#	1st Assignment
#
# 	Pseudocode by MARIA TOGANTZH (mst@aueb.gr)
#
# 	MIPS Code by Komnas Kafasis
#   email: p3190081@aueb.gr
#   id number: 31900891 


	.text
    .globl main

# ------------------- Read and Validate Data ------------------------------

main:
    li $t1,0
    lw $t0,counter              # counter = 4

loop: beqz $t0,exit_loop2      # while counter != 0 do

    li $v0,12			        #	Read hex character in $v0
    syscall

	blt $v0,'0',exit_on_error   # if charakter is not ('0'..'9') and is not ('A'..'F') then
    bgt $v0,'9',exit_on_error   # goto exit_on_error
    blt $v0,'A',exit_on_error
    bgt $v0,'F',exit_on_error    
                                # else 	
    j isHex                     #   goto isHex

isHex:
    sll $t1,$t1,8           # 	shift left $t1
    or $t1,$t1,$v0          # 	pack $v0 to $t1 
    sub $t0,$t0,1           # 	counter = counter - 1
                            #
    j loop                  # goto loop
		
# ------------------- Calculate Decimal Number -----------------------------		

exit_loop:
    lw $a0,CRLF	    # print '\n'
	li $v0,4			
	syscall				

    li $t4,0            # result = 0
						#
	lw $t0,counter		# counter = 4
						# 
	lw $t3,power		# power = 1
						# 
	lw $s1,mask		    # $s1 = 255 (mask = 11111111)


loop2:beqz $t0,exit_loop2  # while counter != 0 do					

	and $t2,$t1,$s1		# 	$t2 =  least significant byte from $t1 (unpack)
    srl $t1,$t1,8		# 	shift right $t1 

	blt $t2,'A',notAtoF # 	if $t2 is letter A..F then 
    bgt $t2,'F',notAtoF #
	sub $t2,$t2,55      # 		$t2 = $t2 - 55
    j compute
notAtoF:				# 	else 
    sub $t2,$t2,48		#		$t2 = $t2 - 48

compute:
	mul $t2,$t2,$t3		# 	$t2 = $t2 * power
	mul $t3,$t3,16		# 	power = power * 16
	sub $t0,$t0,1		# 	counter = counter - 1
	add $t4,$t4,$t2		# 	result = result + $t2
	j loop2  		    # goto loop2

# ------------------- Print Results ------------------------------------		

exit_loop2:				
    move $a0,$t4        # print result
    li $v0,1
    syscall				    
    j exit              # goto exit

exit_on_error:
	lw $a0,CRLF         # print '\n'
	li $v0,4			
	syscall	

	lw $a0,error		# print error message
    li $v0,4
    syscall

exit:					
    lw $a0,CRLF         # print '\n'
	li $v0,4			
	syscall	

	li $v0,10           # exit
    syscall				


	.data
	
error: .asciiz "Wrong Hex Number ..."
CRLF: .asciiz "\n"
mask: .word 255
power: .word 1
counter: .word 4