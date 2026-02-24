# 11.  Search for palindrome and unique words in a text using class method and string method. 
# Sajjad Ahmed Shaaz, 002410501093

class MyWords:
    words = []
    def __init__(self, text):
        MyWords.words=text.split(' ')

    # checks unique words
    def uniqueWords():
        freq = {}

        for word in MyWords.words:
            if word in freq:
                freq[word]+=1
            else:
                freq[word]=1
        
        unique=[]
        for word in freq:
            if freq[word]==1:
                unique.append(word)
        return unique
    
    # checks palindrome words
    def palindromeWords():
        palin=[]
        for word in MyWords.words:
            if word[::-1]==word:
                palin.append(word)
        return palin
    

str=input("Enter string to check: ")
mywords=MyWords(str)
print("palindrome words: ", MyWords.palindromeWords())
print("unique     words: ", MyWords.uniqueWords())