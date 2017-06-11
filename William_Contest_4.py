# ACSL 2016-17 Senior Contest 4
# By William Li (Grade 12) from John P Stevens HS

def boardPrint(x):
	for i in x:
		print i
	print ""
def removeNumbers(l, n):		# removes elements in list n from list l
	return [x for x in l if x not in n]
def removeDuplicates(board):
	for i in range(len(board)):
		for j in range(len(board[i])):
			if len(board[i][j]) == 1:
				num = board[i][j]
				board[i] = [removeNumbers(x, num) for x in board[i]]
				for k in range(len(board)):
					board[k][j] = removeNumbers(board[k][j],num)
				board[i][j] = num
def checkOnlyNum(board):
	for i in range(len(board)):
		for j in range(len(board[i])):
			for k in board[i][j]:
				# if len(board[i][j]) > 1 and sum([x.count(k) for x in [board[y][j] for y in range(len(board))]]) == 1:
				# 	board[i][j] = [k]
				if len(board[i][j]) > 1 and sum([x.count(k) for x in [board[i][y] for y in range(len(board))]]) == 1:
					board[i][j] = [k]
def finalBoardPrint(b):
	out = []
	for i in b:
		num = ""
		for j in i:
			num += str(j[0])
		out.append(num)
	return ", ".join(out)
def boardIsDone(board):
	for i in board:
		for j in i:
			if len(j) != 1:
				return False
	return True
def getMultiple(board, n):
	count = 0
	for i in range(len(board)):
		for j in range(len(board[i])):
			if len(board[i][j]) > 1:
				count += 1
				if count == n:
					return [i, j]
	return [-1,-1]

for loop in range(5):
	data = [int(x) for x in raw_input().split(",")]
	size = len(str(data[0]))
	borders = [[0]*size]*4
	borders[0] = [int(x) for x in str(data[0])]
	borders[1] = [int(str(data[x])[0]) for x in range(1,len(data)-1)]
	borders[2] = [int(str(data[x])[1]) for x in range(1,len(data)-1)]
	borders[3] = [int(x) for x in str(data[-1])]
	board = [[range(1,size+1) for i in range(size)] for j in range(size)]

	# Guaranteed numbers and impossibilities based on boundaries
	for i in range(len(borders)):
		for j in range(len(borders[i])):
			if borders[i][j] == size:
				if i == 0:
					for k in range(size):
						board[k][j] = [k + 1]
				elif i == 1:
					board[j] = [[x+1] for x in range(size)]
				elif i == 2:
					board[j] = [[x] for x in range(size,0,-1)]
				elif i == 3:
					for k in range(size):
							board[k][j] = [size - k]
			elif borders[i][j] == 1:
				if i == 0:
					board[0][j] = [size]
				elif i == 1:
					board[j][0] = [size]
				elif i == 2:
					board[j][-1] = [size]
				elif i == 3:
					board[-1][j] = [size]
			elif borders[i][j] == 2:
				if i == 0:
					if board[2][j] == [size]:
						board[0][j] = removeNumbers(board[0][j], [1])
				elif i == 1:
					if board[j][2] == [size]:
						board[j][0] = removeNumbers(board[j][0], [1])
				elif i == 2:
					if board[j][-2] == [size]:
						board[j][-1] = removeNumbers(board[j][-1], [1])
				elif i == 3:
					if board[-2][j] == [size]:
						board[-1][j] = removeNumbers(board[-1][j], [1])
			else:
				toBeRemoved = range(size, 2, -1)
				for k in range(1,borders[i][j]):
					if i == 0:
						board[borders[i][j]-k-1][j] = removeNumbers(board[borders[i][j]-k-1][j],toBeRemoved[:k])
					elif i == 1:
						board[j][borders[i][j]-k-1] = removeNumbers(board[j][borders[i][j]-k-1],toBeRemoved[:k])
					elif i == 2:
						board[j][-(borders[i][j]-k)] = removeNumbers(board[j][-(borders[i][j]-k)],toBeRemoved[:k])
					elif i == 3:
						board[-(borders[i][j]-k)][j] = removeNumbers(board[-(borders[i][j]-k)][j],toBeRemoved[:k])

	# Manipulating the board - don't use the boundaries
	temp = 0
	guessing = False
	attempt = 1
	while not boardIsDone(board):
		while temp != board:
			temp = board[:]
			removeDuplicates(board)
			# horizontal repeating duplicates
			for j in range(len(board)):
				repeat = [x for x in board[j] if board[j].count(x) == 2]
				if len(repeat) == 2 and len(repeat[0]) == 2:
					board[j]=[removeNumbers(x,repeat[0]) if x != repeat[0] else x for x in board[j] ]
			# vertical repeating duplicates
			for j in range(len(board)):
				tempList = [board[x][j] for x in range(len(board))]
				repeat = [x for x in tempList if tempList.count(x) == 2]
				if len(repeat) == 2 and len(repeat[0]) == 2:
					for k in range(len(board)):
						if board[k][j] != repeat[0]:
							board[k][j] = removeNumbers(board[k][j],repeat[0])
			checkOnlyNum(board)
			if not guessing:
				print "resetting the board"
				reset = board[:]
				# print "reset"
				# boardPrint(reset)
			# boardPrint(board)
		print "reset", guessing
		boardPrint(reset)
		if boardIsDone(board):
			break
		# print "start guessing"
		# Start Guessing
		guessing = True
		board = reset[:]
		coords = getMultiple(board, attempt)
		attempt += 1
		if coords[0] < 0:
			# print "out of guess attempts"
			# boardPrint(reset)
			if not boardIsDone(board):
				board = reset[:]
			break
		board[coords[0]][coords[1]] = [board[coords[0]][coords[1]][0]]
	
	print finalBoardPrint(board)