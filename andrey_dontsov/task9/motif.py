# TASK 9
# http://rosalind.info/problems/subs/

import re

st1, st2 = '', ''
with open('rosalind_subs.txt', 'r') as inp_file:
    file_string = inp_file.read()
    st1, st2 = file_string.splitlines()

print([m.start()+1 for m in re.finditer(f'(?={st2})', st1)])
