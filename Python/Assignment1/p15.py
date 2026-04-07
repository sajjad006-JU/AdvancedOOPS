# 15.   Make a list of the largest or smallest N items in a collection

import heapq

data = [10, 4, 5, 8, 20, 15]

print(heapq.nlargest(3, data))
print(heapq.nsmallest(3, data))