push 0
push function0
push function1
lfp
push -3
lfp
add
lw
lfp
push -2
lfp
add
lw
js
print
halt


function0:
cfp
lra
lfp
push 2
lfp
push 3
lfp
add
lw
js
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js


function1:
cfp
lra
push 1
lfp
add
lw
print
srv
sra
pop
pop
sfp
lrv
lra
js
