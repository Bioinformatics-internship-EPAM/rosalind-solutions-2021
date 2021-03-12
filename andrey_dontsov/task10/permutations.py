from itertools import permutations

n = 0
with open('rosalind_perm.txt', 'r') as inp_file:
    n = int(inp_file.read())
t = [i for i in range(1, n+1)]
with open('outp.txt', 'w') as res_file:
    res_file.write(str(len(list(permutations(t)))))
    res_file.write('\n')
    for i in (permutations(t)):
        res_file.write(str(i).replace(',', '')[1:-1]+'\n')
