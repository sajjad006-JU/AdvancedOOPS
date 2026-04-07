# 29.  Quicksort  is  one  of  the  most  efficient  sorting  algorithms  and  is  commonly  implemented  using 
# recursion. However, recursion can cause stack overflow errors when dealing with very large datasets. 
# To  overcome this, we can use an iterative version of Quicksort that replaces recursive calls with an 
# explicit stack to manage subarrays. Implement it.

def quicksort(arr):
    stack = [(0, len(arr)-1)]

    while stack:
        low, high = stack.pop()
        if low < high:
            pivot = arr[high]
            i = low - 1

            for j in range(low, high):
                if arr[j] <= pivot:
                    i += 1
                    arr[i], arr[j] = arr[j], arr[i]

            arr[i+1], arr[high] = arr[high], arr[i+1]
            pi = i+1

            stack.append((low, pi-1))
            stack.append((pi+1, high))

    return arr

print(quicksort([10, 7, 8, 9, 1, 5]))