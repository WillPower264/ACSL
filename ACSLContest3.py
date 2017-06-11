'''
Created on Feb 13, 2016

@author: William's PC
'''
def formula1(num): return 4*(num/6 - 1) + num%6 - 1
def formula2(num, grid):
    if num < 6:
        while grid[num-1-1] == 9: num += 4
        return num-1
    if num > 31:
        while grid[num-19-1]==9: num -= 4        
        return num - 19
    if num % 6 == 0:
        num = formula1(num)+1
        while grid[num - 1]==9: num -= 1
        return num
    if num % 6 != 0:
        num = formula1(num)+1
        while grid[num - 1]==9: num += 1
        return num
def findNums(num, grid):
    nums = []; temp = num
    for i in range(4): nums.append(grid[(num+4*i)%16]); nums.append(grid[4*(temp/4)+i])
    return nums
def solve(num, grid):
    if grid[num] != 0: return
    nums = set(findNums(num, grid))
    if len(nums)==4: grid[num]=list(set([0,1,2,3,9])-nums)[0]
    return

for q in range(5):
    letters = tuple(raw_input().split(','))
    grid = [0]*16
    for i in range(4): grid[formula1(int(letters[i]))-1]=9
    for i in range(int(letters[4])): grid[formula2(int(letters[2*(i+3)]),grid)-1] = ord(letters[2*(i+3)-1][len(letters[2*(i+3)-1])-1])-64
    while sum(grid) != 60: solve(i%16, grid); i+=1
    print ''.join(str(x) for x in grid).replace('9','').replace('1', 'A').replace('2','B').replace('3','C')