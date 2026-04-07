# 24.  You are given a string . Your task is to find the first occurrence of an alphanumeric character in  
# (read from left to right) that has consecutive repetitions using Group(), Groups() and Groupdict(). 

import re

s = "abbcddd"
match = re.search(r'([a-zA-Z0-9])\1+', s)

if match:
    print(match.group())

