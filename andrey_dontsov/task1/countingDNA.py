# TASK 1
# http://rosalind.info/problems/dna/
nuce_symbols = ['A', 'C', 'G', 'T']
with open('rosalind_dna.txt', 'r') as dna_file:
    dna_code = dna_file.read()
    res = {nuce:dna_code.count(nuce) for nuce in nuce_symbols}
print(res.values())
