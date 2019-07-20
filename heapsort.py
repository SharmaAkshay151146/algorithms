import numpy as np

def heapify(data, n, i):
	largest = i # root as the largest element
	left = 2*i+1
	right = 2*i+2

	# Check if left child exists and is greater than root
	if left < n and data[i] < data[left]:
		largest = left

	# Do the same for the right child
	if right < n and data[largest] < data[right]:
		largest = right

	if largest != i:
		data[i], data[largest] = data[largest], data[i]
		heapify(data,n,largest)


def heap_sort(data):
	length = len(data)

	# Build a heap
	for i in range(length, -1, -1):
		heapify(data, length, i)

	# Get elements one by one
	for i in range(length-1, 0, -1):
		data[i], data[0] = data[0], data[i] # swap
		heapify(data, i, 0)

def main():
    data = np.random.randint(1,1001,10)
    print(data)
    heap_sort(data)
    print(data)

main()