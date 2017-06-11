'''
Created on May 28, 2016

@author: William's PC
'''
from itertools import permutations
for x in range(10): 
    word = raw_input()
    letters = list(word)
    perms = sorted(list(set([''.join(c) for c in permutations(letters)])))
    print perms.index(word)+1 
