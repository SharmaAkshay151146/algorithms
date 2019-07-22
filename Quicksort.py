import numpy as np 

def quickSort(alist):
    quickSortHelper(alist, 0, len(alist)-1)

def quickSortHelper(alist,first,last):
    if first < last:
        splitpoint = partition(alist,first,last)
        quickSortHelper(alist,first,splitpoint-1)
        quickSortHelper(alist,splitpoint+1,last)

def partition(alist,first,last):
    pivot = alist[first]
    leftmark = first+1
    rightmark = last 
    done = False 
    
    while not done:
        while leftmark <= rightmark and alist[leftmark] <= pivot:
            leftmark = leftmark + 1
        
        while alist[rightmark] >= pivot and rightmark >= leftmark:
            rightmark -= 1
        
        if rightmark < leftmark:
            done = True 
        else:
            alist[leftmark],alist[rightmark] = alist[rightmark],alist[leftmark]
    
    alist[first], alist[rightmark] = alist[rightmark], alist[first]
    return rightmark 

def main():
    alist = np.random.randint(1,1001,10)
    print(alist)
    quickSort(alist)
    print(alist)

main()
