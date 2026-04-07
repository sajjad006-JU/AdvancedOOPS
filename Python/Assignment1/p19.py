# 19.  Use  profile/cprofile  to  check  pythogorian  triples  code  in  python.  Think  about  time 
# complexity of the code.

import cProfile

def triples(n):
    res = []
    for a in range(n):
        for b in range(n):
            for c in range(n):
                if a*a + b*b == c*c:
                    res.append((a,b,c))
    return res

cProfile.run("triples(50)")

