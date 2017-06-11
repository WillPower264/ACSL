'''
Created on Mar 29, 2016

@author: William's PC
'''
import re
strings = raw_input().split(', ')
for x in range(5):
    patt = raw_input(); out = []
    for i in strings: 
        if re.match(patt+"\Z", i): out.append(i) 
    if len(out) < 1: out.append("NONE")
    for i in out: print i,
    print
