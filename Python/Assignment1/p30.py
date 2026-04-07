# 30. Given two numbers N and K, the task is to print a number series where each term is obtained by 
# repeatedly subtracting K from N until the number becomes zero or negative and once it becomes zero 
# or negative, we start adding K back until the number reaches the original value N again. You must do 
# this without using any loop. 
# For Example: 
# Input: N = 15, K = 5 
# Output: 15 10 5 0 -5 0 5 10 15 
# Input: N = 20, K = 6 
# Output: 20 14 8 2 -4 2 8 14 20
# Sajjad Ahmed Shaaz, 002410501093

def series(n, k):
    # 1. Print the current number as we go down
    print(n, end=" ")

    # 2. Base case: if the number becomes zero or negative, stop subtracting
    if n <= 0:
        return

    # 3. Recursive step: subtract K
    series(n - k, k)

    # 4. As the recursion unwinds (returns), print the number again
    print(n, end=" ")

# Test cases
print("Input: N = 15, K = 5")
series(15, 5)

print("\n\nInput: N = 20, K = 6")
series(20, 6)