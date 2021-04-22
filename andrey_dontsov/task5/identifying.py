# TASK5
# http://rosalind.info/problems/gc/

source_dict = {}
current_key = ''
dna_line = ''
with open('rosalind_gc.txt', 'r') as inp_f:
    file_string = inp_f.read()
file_list = file_string.splitlines()
for line in file_list[::-1]:
    if '>' in line:
        source_dict[line] = dna_line
        dna_line = ''
    else:
        dna_line += line

res = ()
max_err = 0
for code in source_dict:
    current_err = (source_dict[code].count('C') + source_dict[code].count('G'))/len(source_dict[code])
    current_err = current_err*100
    if current_err > max_err:
        res = (code, current_err)
        max_err = current_err

print(f'{res[0][1::]}\n{res[1]}')
