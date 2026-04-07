# 16.   Create a dictionary that maps stock names to prices, which will keep insertion 
# order.Find minimum price, maximum price and sort items according to their prices in 
# first  dictionary  using  itemgetter  or  lambda  function.  Create  another second stock 
# dictionary. Find items that are only in first dictionary and find items whose prices do 
# not  match.  Remove duplicate items from first dictionary. Sort both dictionaries for 
# incrementing prices. Group items in first dictionary by price in multiple of 500. Find 
# an item with price=800 from both dictionaries.

from operator import itemgetter

stocks1 = {"A": 1000, "B": 800, "C": 1200}
stocks2 = {"B": 800, "C": 1000, "D": 500}

print(min(stocks1.items(), key=itemgetter(1)))
print(max(stocks1.items(), key=itemgetter(1)))

print(sorted(stocks1.items(), key=lambda x: x[1]))

only_in_1 = stocks1.keys() - stocks2.keys()
print(only_in_1)

diff_price = {k for k in stocks1 if k in stocks2 and stocks1[k] != stocks2[k]}
print(diff_price)

stocks1 = dict(stocks1)

grouped = {}
for k, v in stocks1.items():
    key = (v // 500) * 500
    grouped.setdefault(key, []).append(k)

print(grouped)