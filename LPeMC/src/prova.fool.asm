push 0
push 2
push 1
push -3
lfp
add
lw
push 1
beq label0
push -2
lfp
add
lw
push 2
add
b label1
label0:
push -2
lfp
add
lw
push 1
add
label1:
print
halt
