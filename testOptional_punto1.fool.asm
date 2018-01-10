push -1
lhp
push function0
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
push function1
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
push function2
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
push function2
lhp
sw
lhp
push 1
add
shp
push function3
lhp
sw
lhp
push 1
add
shp
lfp
push -5
add
lw
lfp
push -3
add
lw
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
push -5
add
lw
lfp
push -5
add
lw
push 2
add
lw
js
b label1
label0:
lfp
lfp
push -3
add
lw
lfp
push -3
add
lw
push 1
add
lw
js
label1:
print
halt


function0:
cfp
lra
push 1
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
push 2
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
push 3
srv
sra
pop
sfp
lrv
lra
js


function3:
cfp
lra
push 4
srv
sra
pop
sfp
lrv
lra
js
