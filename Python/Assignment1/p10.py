# Write a code which yields all terms of the geometric progression a, aq, aq2  , aq3  , .... 
# Sajjad Ahmed Shaaz, 002410501093

# returns gp terms
def gp(a, q):
    x=a

    while True:
        yield x
        x=x*q

a = int(input("enter the value of a : "))
q = int(input("enter the value of q : "))

series = gp(a, q)
print(next(series))
print(next(series))
print(next(series))
print(next(series))
print(next(series))
