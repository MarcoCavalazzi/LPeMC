push 0
lhp 
sw 
lhp
push 1
lhp
add
shp
push 111

lhp
sw
push 1
lhp
add
shp
push 222

lhp
sw
push 1
lhp
add
shp
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
push function1
lhp
sw
push 1
lhp
add
shp
lhp
lhp
push 3
lw
js
print
halt


function0:
cfp
lra
push 2
lfp
lw
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
push 123
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
push 999
srv
sra
pop
sfp
lrv
lra
js
