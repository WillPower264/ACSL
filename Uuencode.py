'''
Created on May 28, 2016

@author: William's PC
'''
for i in range (10):
    before = raw_input()
    before += (3-len(before)%3)%3*'0'
    before = [ord(c)+256 for c in before]
    before = "".join([bin(c)[3:] for c in before])
    after = []
    for j in range (len(before)/6): after.append(before[j*6:j*6+6])
    after = "".join([chr(int(c,2)+32) for c in after])
    after.replace(' ', '~')
    print after