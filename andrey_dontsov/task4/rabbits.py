# TASK 4
# http://rosalind.info/problems/fib/

def rabbits(n, k):
    if (n == 1) or (n == 2):
        return 1
    return rabbits(n-2,k)*k + rabbits(n-1, k)

print(rabbits(30, 5))
