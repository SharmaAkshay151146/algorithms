import numpy as np


def merge_sort(data):
    
    if len(data)>1:
        mid = len(data)//2
        left = data[:mid]
        right = data[mid:]

        merge_sort(left)
        merge_sort(right)

        i=0
        j=0
        k=0

        # Adding elements to a temp list
        while i < len(left) and j < len(right):
            if left[i] <= right[j]:
                data[k]=left[i]
                i=i+1
            else:
                data[k]=right[j]
                j=j+1
            k=k+1
        # Adding remaining elements
        while i < len(left):
            data[k]=left[i]
            i=i+1
            k=k+1

        while j < len(right):
            data[k]=right[j]
            j=j+1
            k=k+1
    return data


def main():
	data = [939, 938, 821, 67, 414, 492, 711, 634, 208, 235]
	print(data)
	print(merge_sort(data))

	

main()