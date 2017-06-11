def getValue(digits):
	return int("".join(digits))

for i in range(5):
	num = list(raw_input().strip())
	out = [getValue(num.pop(0))]
	while len(num) > 0:
		candidate = ["0"]
		while getValue(candidate) <= out[-1]:
			candidate.append(num.pop())
			if len(num) < 1: break
		if getValue(candidate) > out[-1]:
			out.append(getValue(candidate))
		num = num[::-1]
	print " ".join([str(x) for x in out])