'''
Created on Jan 22, 2016

@author: William's PC
'''
for i in range(5):
    test = raw_input().split(',')
    sign = test[0][0] if len(test[0])!=len(str(abs(float(test[0])))) else '' 
    out = sign + str(round(abs(float(test[0])),int(test[2])))
    while len(out[out.find('.'):])!=int(test[2])+1: out+="0"
    if len(out)==int(test[1]): print out
    elif len(out)>int(test[1]): print '#'*(int(test[1])-int(test[2])-1)+'.'+'#'*(int(test[2]))
    else: print '#'*(int(test[1])-len(out))+out