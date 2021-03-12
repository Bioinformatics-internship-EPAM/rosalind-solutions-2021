# TASK 3
# http://rosalind.info/problems/revc/

complementing = {'A':'T', 'C':'G', 'T':'A', 'G':'C'}

with open('rosalind_revc.txt', 'r') as inp_file:
    inp_string = inp_file.read()[:-1]
    res = ''.join([complementing[sym] for sym in inp_string[::-1]])
print(res)
