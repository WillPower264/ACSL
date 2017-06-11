'''
Created on May 29, 2016

@author: William's PC
'''
for i in range(10):
    num = input()
    length = num[1] if type(num) == tuple else 10
    dec = num[2] if type(num) == tuple and len(num) > 2 else 0
    num = num[0] if type(num) == tuple else num
    out = str(round(num, dec))
    if dec == 0: out = out[:-2]
    elif len(out[out.index('.'):])-1 < dec: out+='0'*(dec-(len(out[out.index('.'):])-1))
    if len(out) > length: print "ERROR"
    elif len(out) <= length: print "#"*(length - len(out))+str(out)