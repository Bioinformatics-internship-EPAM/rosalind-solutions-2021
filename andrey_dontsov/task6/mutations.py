# TASK 6
# http://rosalind.info/problems/hamm/

def hamming_dist(dna1: str, dna2: str) -> int:
    dist = 0
    for pair in list(zip(dna1, dna2)):
        if pair[0] != pair[1]:
            dist += 1
    return dist

strings = ''
with open('rosalind_hamm.txt', 'r') as inp_file:
    strings = inp_file.read()

dna_strings = strings.splitlines()
print(hamming_dist(dna_strings[0], dna_strings[1]))
