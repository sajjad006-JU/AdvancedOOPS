# 13.  Write an operator overloading for len which shows string length for any given string 
# and return only length of repetitive words with the text if the text has some repetitive parts. 
# Determine the most frequently occurring words using most_common. Count string length in 
# 4 different ways
from collections import Counter

class MyString:
    def __init__(self, text):
        self.text = text

    def __len__(self):
        words = self.text.split()
        freq = Counter(words)
        repetitive = [w for w, c in freq.items() if c > 1]
        return sum(len(w) for w in repetitive)

    def length_methods(self):
        print(len(self.text))
        print(sum(1 for _ in self.text))
        print(self.text.__len__())
        print(len([c for c in self.text]))

    def most_common_words(self):
        return Counter(self.text.split()).most_common()
    
s = MyString("hello world hello")
print(len(s))  # Should return length of "hello" which is 5
s.length_methods()