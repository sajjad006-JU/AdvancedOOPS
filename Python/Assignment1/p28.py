# 28.  Given  an  array  of strings containing lowercase letters, the task is to find the size of the largest 
# subset of words that are anagrams of each other. Two strings are said to be anagrams if they contain 
# the same characters, only in a different order.

from collections import defaultdict

def largest_anagram(words):
    d = defaultdict(list)

    for w in words:
        key = ''.join(sorted(w))
        d[key].append(w)

    return max(len(v) for v in d.values())


print(largest_anagram(["listen", "silent", "enlist", "inlets", "google", "gooogle"]))