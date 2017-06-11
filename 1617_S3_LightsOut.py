# ACSL 2016-17 Senior Contest 3
# By William Li (Grade 12) from John P Stevens HS

def translate(digits):
	digits = "".join(digits.split(" "))
	digits = [str(bin(int(x,16)))[2:] for x in digits]
	digits = "".join(["0"*(4-len(x))+x for x in digits])
	digits = [digits[i:i+8] for i in range(0, len(digits), 8)][::-1]
	return digits

def findDifferences(board1, board2):
	diff = []
	for x in range(8):
		for y in range(8):
			if board1[x][y] != board2[x][y]:
				diff.append([8-x,y+1])
	return diff

def findMost(differences):
	dic = {}
	for x in differences:
		if x not in dic.keys():
			dic[x] = 1
		else:
			dic[x]+=1
	return max(dic, key=dic.get)

board1 = translate(raw_input())
for i in range(5):
	board2 = translate(raw_input())
	diff = findDifferences(board1, board2)
	print str(findMost([x[0] for x in diff])) + str(findMost([x[1] for x in diff]))
	board1 = board2
