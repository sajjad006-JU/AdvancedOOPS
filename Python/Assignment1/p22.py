# 22.  There is a complex matrix script. The matrix script is a   X   grid of strings. It consists of 
# alphanumeric characters, spaces and symbols (!,@,#,$,%,&).
# If  there  are  symbols  or  spaces  between  two  alphanumeric  characters  of  the  decoded  script,  then 
# replace them with a single space '' for better readability. There is no need to use 'if' conditions for 
# decoding.  Alphanumeric  characters  consist  of:  [A-Z,  a-z,  and  0-9].  0<N,  M<100.  Print the decoded 
# matrix script

import re

def decode(matrix):
    rows = len(matrix)
    cols = len(matrix[0])

    result = ""
    for c in range(cols):
        for r in range(rows):
            result += matrix[r][c]

    return re.sub(r'(?<=\w)[^\w]+(?=\w)', ' ', result)

# Example usage:
matrix = [
    "A!B@C",
    "D#E$F",
    "G%H&I"
]

decoded_script = decode(matrix)
print(decoded_script)