'''
Created on May 28, 2016

@author: William's PC
'''
def method1 (com):
    out = []
    out1 = []
    for i in com:
        if i not in ('+', '-', '='):
            out1.append(i)
        if i in ('+', '-', '='):
            out.append("".join(out1))
            out.append(i)
            out.append("".join(com[com.index(i)+1:]))
            return out
                   
people = {'u':0, 'g':1, 'o':2}
permissions = {'r':0, 'w':1, 'x':2}
    
for i in range(10):
    nums = raw_input().split(", ")
    numOut = "".join((bin(int(nums[0][0]) + 8)[3:6], bin(int(nums[0][1]) + 8)[3:6], bin(int(nums[0][2]) + 8)[3:6]))
    letOut = list("rwxrwxrwx")
    for i in range(len(numOut)):
        if numOut[i] == '0': letOut[i] = '-'
    
    commands=[]
    for j in range(1, len(nums)): commands.append(method1(list(nums[j])))
    for j in commands:
        if j[0] == 'a': j[0] = 'ugo'
        for k in range(len(j[0])):
            person = people[j[0][k]]*3
            if j[1] == '=':
                letOut[person] = '-'
                letOut[person + 1] = '-'
                letOut[person + 2] = '-'
            if j[1] == '+' or j[1] == '=':
                for l in j[2]: letOut[person+permissions[l]]=l
            if j[1] == '-':
                for l in j[2]: letOut[person+permissions[l]]='-'
                    
    print "".join(letOut) 
