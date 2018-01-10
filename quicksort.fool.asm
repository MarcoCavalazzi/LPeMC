push -1
lfp
push function2
lfp
push function5
lfp
push function8
lfp
push function11
lfp
push function14
lfp
push function16
push -1
lhp
sw
lhp
push 1
add
shp
push 5
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
sw
lhp
push 1
add
shp
push 2
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
sw
lhp
push 1
add
shp
push 1
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
sw
lhp
push 1
add
shp
push 6
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
sw
lhp
push 1
add
shp
push 4
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
sw
lhp
push 1
add
shp
push -3
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
lfp
lfp
lfp
push -14
add
lw
lfp
push -10
add
lw
lfp
push -10
push 1
sub
add
lw
js
lfp
push -2
add
lw
lfp
push -2
push 1
sub
add
lw
js
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


function3:
cfp
lra
lfp
push 1
add
lw
lhp
sw
lhp
push 1
add
shp
lfp
push 2
add
lw
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
srv
sra
pop
pop
pop
sfp
lrv
lra
js


function4:
cfp
lra
lfp
push 1
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
print
lfp
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
lfp
lw
push -4
add
lw
lfp
lw
push -4
push 1
sub
add
lw
js
lfp
lw
push -2
add
lw
lfp
lw
push -2
push 1
sub
add
lw
js
b label1
label0:
push -1
label1:
srv
sra
pop
pop
sfp
lrv
lra
js


function2:
cfp
lra
lfp
push function3
lfp
push function4
lfp
lfp
push 1
add
lw
lfp
push -4
add
lw
lfp
push -4
push 1
sub
add
lw
js
srv
pop
pop
pop
pop
sra
pop
pop
sfp
lrv
lra
js


function6:
cfp
lra
lfp
push 1
add
lw
lhp
sw
lhp
push 1
add
shp
lfp
push 2
add
lw
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
srv
sra
pop
pop
pop
sfp
lrv
lra
js


function7:
cfp
lra
lfp
push 1
add
lw
push -1
beq label6
push 0
b label7
label6:
push 1
label7:
push 1
beq label4
lfp
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
print
lfp
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
lfp
lw
push -4
add
lw
lfp
lw
push -4
push 1
sub
add
lw
js
lfp
lw
push -2
add
lw
lfp
lw
push -2
push 1
sub
add
lw
js
b label5
label4:
push -1
label5:
srv
sra
pop
pop
sfp
lrv
lra
js


function5:
cfp
lra
lfp
push function6
lfp
push function7
lfp
push 1
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
push 2
add
lw
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
lfp
lw
push -4
add
lw
lfp
lw
push -4
push 1
sub
add
lw
js
lhp
sw
lhp
push 1
add
shp
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
b label9
label8:
lfp
push 2
add
lw
label9:
srv
pop
pop
pop
pop
sra
pop
pop
pop
sfp
lrv
lra
js


function9:
cfp
lra
lfp
push 1
add
lw
lhp
sw
lhp
push 1
add
shp
lfp
push 2
add
lw
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
srv
sra
pop
pop
pop
sfp
lrv
lra
js


function10:
cfp
lra
lfp
push 1
add
lw
push -1
beq label14
push 0
b label15
label14:
push 1
label15:
push 1
beq label12
lfp
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
print
lfp
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
lfp
lw
push -4
add
lw
lfp
lw
push -4
push 1
sub
add
lw
js
lfp
lw
push -2
add
lw
lfp
lw
push -2
push 1
sub
add
lw
js
b label13
label12:
push -1
label13:
srv
sra
pop
pop
sfp
lrv
lra
js


function8:
cfp
lra
lfp
push function9
lfp
push function10
lfp
push 1
add
lw
push -1
beq label18
push 0
b label19
label18:
push 1
label19:
push 1
beq label16
lfp
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
push 3
add
lw
lfp
push 3
push 1
sub
add
lw
js
push 1
beq label20
lfp
lfp
push 3
add
lw
lfp
push 3
push 1
sub
add
lw
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
lfp
lw
push -6
add
lw
lfp
lw
push -6
push 1
sub
add
lw
js
b label21
label20:
lfp
lfp
push 3
add
lw
lfp
push 3
push 1
sub
add
lw
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
lfp
lw
push -6
add
lw
lfp
lw
push -6
push 1
sub
add
lw
js
lhp
sw
lhp
push 1
add
shp
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
label21:
b label17
label16:
push -1
label17:
srv
pop
pop
pop
pop
sra
pop
pop
pop
pop
sfp
lrv
lra
js


function12:
cfp
lra
lfp
lfp
lw
push -2
add
lw
lfp
push 1
add
lw
lfp
lw
push 3
add
lw
lfp
lw
push 3
push 1
sub
add
lw
js
srv
sra
pop
pop
sfp
lrv
lra
js


function13:
cfp
lra
lfp
lfp
push 1
add
lw
lfp
lw
push -2
add
lw
lfp
lw
push 3
add
lw
lfp
lw
push 3
push 1
sub
add
lw
js
srv
sra
pop
pop
sfp
lrv
lra
js


function11:
cfp
lra
lfp
push 1
add
lw
push -1
beq label24
push 0
b label25
label24:
push 1
label25:
push 1
beq label22
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
b label23
label22:
push 0
label23:
lfp
push function12
lfp
push function13
lfp
push 1
add
lw
push -1
beq label28
push 0
b label29
label28:
push 1
label29:
push 1
beq label26
lfp
lfp
lfp
push 3
add
lw
lfp
push 3
push 1
sub
add
lw
lfp
lfp
push -5
add
lw
lfp
push -5
push 1
sub
add
lw
lfp
push 1
add
lw
lfp
lw
push -6
add
lw
lfp
lw
push -6
push 1
sub
add
lw
js
lfp
lw
push -8
add
lw
lfp
lw
push -8
push 1
sub
add
lw
js
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
lfp
lfp
push 3
add
lw
lfp
push 3
push 1
sub
add
lw
lfp
lfp
push -3
add
lw
lfp
push -3
push 1
sub
add
lw
lfp
push 1
add
lw
lfp
lw
push -6
add
lw
lfp
lw
push -6
push 1
sub
add
lw
js
lfp
lw
push -8
add
lw
lfp
lw
push -8
push 1
sub
add
lw
js
lfp
lw
push -4
add
lw
lfp
lw
push -4
push 1
sub
add
lw
js
b label27
label26:
push -1
label27:
srv
pop
pop
pop
pop
pop
sra
pop
pop
pop
pop
sfp
lrv
lra
js


function15:
cfp
lra
lfp
push 2
add
lw
lfp
push 1
add
lw
bless label32
push 0
b label33
label32:
push 1
label33:
push 1
beq label30
push 1
b label31
label30:
push 0
label31:
srv
sra
pop
pop
pop
sfp
lrv
lra
js


function14:
cfp
lra
lfp
push function15
lfp
lfp
push -2
add
lw
lfp
push -2
push 1
sub
add
lw
lfp
push 1
add
lw
lfp
lw
push -8
add
lw
lfp
lw
push -8
push 1
sub
add
lw
js
srv
pop
pop
sra
pop
pop
sfp
lrv
lra
js


function17:
cfp
lra
lfp
push 1
add
lw
lfp
push 2
add
lw
bless label36
push 0
b label37
label36:
push 1
label37:
push 1
beq label34
push 1
b label35
label34:
push 0
label35:
srv
sra
pop
pop
pop
sfp
lrv
lra
js


function16:
cfp
lra
lfp
push function17
lfp
lfp
push -2
add
lw
lfp
push -2
push 1
sub
add
lw
lfp
push 1
add
lw
lfp
lw
push -8
add
lw
lfp
lw
push -8
push 1
sub
add
lw
js
srv
pop
pop
sra
pop
pop
sfp
lrv
lra
js
