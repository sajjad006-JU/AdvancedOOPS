# Sajjad Ahmed Shaaz, 002410501093

import itertools

data = range(21)

even_nos = [num%2==0 for num in data]
odd_nos = [num%2==1 for num in data]

even_iterator = itertools.compress(data, even_nos)
odd_iterator = itertools.compress(data, odd_nos)

print([next(even_iterator) for _ in range(10)])
print([next(odd_iterator) for _ in range(10)])