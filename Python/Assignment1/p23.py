# 23.  You are given a string, and you have to validate whether it's a valid Roman numeral. If it is valid, 
# print True. Otherwise, print False. Try to create a regular expression for a valid Roman numeral. The 
# number will be between  1 and 3999 (both included)

import re

pattern = r"^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"

def is_valid(roman):
    return bool(re.match(pattern, roman))

# Test cases
print(is_valid("XII"))  # True
print(is_valid("MCMXCIV"))  # True
print(is_valid("MMMM"))  # False
print(is_valid("IC"))  # False