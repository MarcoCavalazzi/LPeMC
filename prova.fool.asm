push 0
push 50000
lhp
sw
push 1
lhp
add
shp
push 3000
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
push 1
lhp
add
shp
push function1
lhp
sw
push 1
lhp
add
shp
push 10000
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
push 1
lhp
add
shp
lhp
push function2
lhp
sw
push 1
lhp
add
shp
push function3
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
push 9000
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
push 1
lhp
add
shp
push function1
lhp
sw
push 1
lhp
add
shp
lfp
lfp
push -2
add
lw
lfp
push -4
add
lw
srv
lrv
lrv
push 1
add
lw
js
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
push 2000
lfp
lw
push -1
add
lw
bless label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 66
b label1
label0:
lfp
lfp
lw
push 0
lfp
lw
add
lw
js
label1:
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
srv
lrv
lrv
push 1
add
lw
js
lfp
lfp
push 1
add
lw
srv
lrv
lrv
push 1
add
lw
js
add
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
srv
lrv
lrv
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
lhp
push function0
lhp
sw
push 1
lhp
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


function4:
cfp
lra
push 20000
lfp
lfp
push 1
add
lw
srv
lrv
lrv
push 1
add
lw
js
bless label10
push 0
b label11
label10:
push 1
label11:
push 1
beq label8
push 123
b label9
label8:
lfp
lfp
push -1
add
lw
srv
lrv
lrv
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
srv
lrv
lrv
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
lhp
push function0
lhp
sw
push 1
lhp
add
shp
push function1
lhp
sw
push 1
lhp
add
shp
label9:
srv
sra
pop
pop
sfp
lrv
lra
js
