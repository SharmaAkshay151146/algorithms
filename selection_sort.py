import time
import numpy as np 

def selection(data):
	for i in range(len(data)):
		min_index = i
		for j in range(i+1, len(data)):
			if data[min_index] > data[j]:
				min_index = j
		data[i], data[min_index] = data[min_index], data[i]

	return data

def main():
	data = np.random.randint(1,1001,10)
	print("Before sorting: ", data)
	selection(data)
	print("After sorting: ", data)

main()

