
N = 50 
nos = list(range(1, N+1))

multiples_of_five = list(filter(lambda x: x%5==0, nos))
print(multiples_of_five)