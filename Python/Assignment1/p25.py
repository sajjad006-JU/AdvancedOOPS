# 25. CSS colors are defined using a hexadecimal (HEX) notation for the combination of Red, Green, and 
# Blue color values (RGB). It must start with a '#' symbol. It can have 3 or 6 digits. Each digit is in the 
# range of 0 to F. You are given N<10 lines of CSS code. Your task is to print all valid Hex Color Codes, in 
# order of their occurrence from top to bottom. Sample Input

import re

# The fixed pattern: explicitly 3 or 6 chars, ignores CSS IDs at the start of a line
pattern = r'(?<!^)(#(?:[0-9a-fA-F]{3}){1,2})\b'

try:
    with open("input.css", "r") as f:
        # If your file has the number 'N' on the first line, uncomment the next line to skip it:
        # next(f) 
        
        for line in f:
            matches = re.findall(pattern, line)
            for m in matches:
                print(m)
except FileNotFoundError:
    print("Error: Could not find 'input.css'. Make sure it is in the same directory as this script.")