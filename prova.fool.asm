push 0
push function0
push function1
lfp
push -2
lfp
add
lw
push 1
lfp
push -3
lfp
add
lw
js
print
halt


function0:
cfp
lra
push 1
lfp
add
lw
push 1
add
srv
sra
pop
pop
sfp
lrv
lra
js


function1:
cfp
lra
lfp
push 1
lfp
add
lw
lfp
push 2
lfp
add
lw
js
push 2
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js
