# .  Write  first seven Fibinacci numbers using generator next function/ yield in python. Trace 
# and memorize the function. Also check whether a user given number is Fibinacci or not. 
# Sajjad Ahmed Shaaz, 002410501093

# returns fibonacci
def fibonacci(n):
    a=0
    b=1

    yield a
    yield b

    while n>2:
        c=a+b
        yield c
        a=b
        b=c
        n-=1

fib_upto_n = fibonacci(7)

print(next(fib_upto_n))
print(next(fib_upto_n))
print(next(fib_upto_n))
print(next(fib_upto_n))
print(next(fib_upto_n))
print(next(fib_upto_n))
print(next(fib_upto_n))