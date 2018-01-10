push -1
push 10
lhp
sw
lhp
push 1
add
shp
lhp
push function0
lhp
sw
lhp
push 1
add
shp
push 5000
lhp
sw
lhp
push 1
add
shp
push 20000
lhp
sw
lhp
push 1
add
shp
lhp
push function1
lhp
sw
lhp
push 1
add
shp
push function2
lhp
sw
lhp
push 1
add
shp
lfp
push -2
add
lw
push -1
beq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
lfp
lfp
push -2
add
lw
lfp
push -2
add
lw
push 0
add
lw
js
b label1
label0:
push 0
label1:
print
halt


function0:
cfp
lra
lfp
lw
push -1
add
lw
srv
sra
pop
sfp
lrv
lra
js


function1:
cfp
lra
lfp
lw
push -2
add
lw
srv
sra
pop
sfp
lrv
lra
js


function2:
cfp
lra
lfp
lw
push -2
add
lw
srv
sra
pop
sfp
lrv
lra
js
