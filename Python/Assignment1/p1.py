# 1.  Write a prime generator program using only primes and using python loops. 
# Sajjad Ahmed Shaaz, 002410501093

# generates primes
def prime_generator():
    primes = []
    n=2

    while True:
        is_prime=True

        for p in primes:
            if p*p>n:
                break
            if n%p==0:
                is_prime=False
                break

        if is_prime:
            primes.append(n)
            yield n
        n+=1

primes=prime_generator()

print(next(primes))
print(next(primes))
print(next(primes))
print(next(primes))
print(next(primes))
print(next(primes))
print(next(primes))
print(next(primes))
print(next(primes))
print(next(primes))
print(next(primes))
print(next(primes))
