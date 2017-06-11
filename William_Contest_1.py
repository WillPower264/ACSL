for i in range(5):
	val = ['','A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K']
	cards = raw_input().split(",")
	cards = [x[-2:] for x in cards]
	suit = cards[0][1]
	candidate = [x for x in cards[1:] if x[1]==suit]
	# Same suit
	if len(candidate) != 0:
		temp = candidate
		candidate = [x for x in candidate if val.index(x[0]) > val.index(cards[0][0])]
		if len(candidate) == 1:
			print candidate[0]
		# Same suit greater
		elif len(candidate) > 1:
			print val[min([val.index(x[0]) for x in candidate])]+suit
		# Same suit less than
		else:
			print val[min([val.index(x[0]) for x in temp])]+suit
	# Different Suit
	else:
		leastRank = val[min([val.index(y[0]) for y in cards[1:]])]
		candidate = [x for x in cards[1:] if x[0]==leastRank]
		if len(candidate) == 1:
			print candidate[0]
		else:
			print [x for x in candidate if x[1]==min([y[1:] for y in candidate])][0]