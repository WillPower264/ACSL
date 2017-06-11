'''
Created on Dec 5, 2015

@author: William's PC
'''
print "Input 5 rows of numbers separated by commas: "
for i in range(5):
    nums = input()
    numOut = bin(nums[1] + 8)[3:6], bin(nums[2] + 8)[3:6], bin(nums[3] + 8)[3:6]
    numOut = " ".join(numOut)
    letOut = list("rwx rwx rwx")
    for i in range(0, len(numOut)):
        if numOut[i] == '0': letOut[i] = '-'
    if nums[0] == 1 or nums[0] == 2:
        if letOut[nums[0] * 4 - 2] == 'x': letOut[nums[0] * 4 - 2] = 's'
    elif nums[0] == 4:
        if letOut[10] == 'x': letOut[10] = 't'
    letOut = "".join(letOut)
    print numOut, "and", letOut

    