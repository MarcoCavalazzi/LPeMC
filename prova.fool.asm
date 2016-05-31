push 0
push 40000
lhp
sw
push 1
lhp
add
shp
push 50000
lhp
sw
push 1
lhp
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
sw
push 1
lhp
add
shp
lhp
push function2
lhp
sw
lhp
push 1
add
shp
push function4
lhp
sw
lhp
push 1
add
shp
push 5000
lhp
sw
push 1
lhp
add
shp
push 20000
lhp
sw
push 1
lhp
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
lfp
lfp
push -3
add
lw
lfp
push -2
add
lw
lfp
push -2
add
lw
push 1
add
lw
js
lfp
push -4
add
lw
push -1
beq label10
push 0
b label11
label10:
push 1
label11:
push 1
beq label8
lfp
lfp
push -4
add
lw
lfp
push -4
add
lw
push 0
add
lw
js
b label9
label8:
push 0
label9:
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


function3:
cfp
lra
push 30000
lfp
lfp
push 1
add
lw
lfp
push 1
add
lw
push 0
add
lw
js
lfp
lfp
push 1
add
lw
lfp
push 1
add
lw
push 1
add
lw
js
add
bless label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push -1
b label1
label0:
lfp
lfp
push -1
add
lw
lfp
push -1
add
lw
push 0
add
lw
js
lhp
sw
push 1
lhp
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
label1:
srv
sra
pop
pop
sfp
lrv
lra
js


function4:
cfp
lra
push 20000
lfp
lfp
push 1
add
lw
lfp
push 1
add
lw
push 0
add
lw
js
bless label6
push 0
b label7
label6:
push 1
label7:
push 1
beq label4
push -1
b label5
label4:
lfp
lfp
push -1
add
lw
lfp
push -1
add
lw
push 1
add
lw
js
lhp
sw
push 1
lhp
add
shp
lfp
lfp
push -1
add
lw
lfp
push -1
add
lw
push 0
add
lw
js
lhp
sw
push 1
lhp
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
label5:
srv
sra
pop
pop
sfp
lrv
lra
js
