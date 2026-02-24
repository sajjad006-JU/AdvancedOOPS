# Enumerate the sequence of all lowercase ASCII letters, starting from 1, using enumerate. 
# Sajjad Ahmed Shaaz, 002410501093

letters = []
for i in range('a', 'z'):
    ord(i)

ascii=enumerate([x for x in range('a', 'z')], start=1)

print(list(ascii))