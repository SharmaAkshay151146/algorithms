def insertion_sort(arr):
	for i in range(1, len(arr)):
		curr = arr[i]
		j = i;
		while(j > 0 and arr[j-1] > curr):
			arr[j] = arr[j-1]
			j = j-1 
		arr[j] = curr 

def main():
	arr = [61, 12, 76, 42, 24, 64, 26]
	print(arr)
	insertion_sort(arr)
	print(arr)

if __name__ == "__main__":
	main()