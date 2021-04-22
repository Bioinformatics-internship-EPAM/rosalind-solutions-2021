# https://www.ncbi.nlm.nih.gov/nuccore/MT135041.1?report=fasta

CODON_TABLE = {
    'UUU': 'F', 'CUU': 'L', 
    'AUU': 'I', 'GUU': 'V',
    'UUC': 'F', 'CUC': 'L',
    'AUC': 'I', 'GUC': 'V',
    'UUA': 'L', 'CUA': 'L',
    'AUA': 'I', 'GUA': 'V',
    'UUG': 'L', 'CUG': 'L',
    'AUG': 'M', 'GUG': 'V',
    'UCU': 'S', 'CCU': 'P',
    'ACU': 'T', 'GCU': 'A',
    'UCC': 'S', 'CCC': 'P',
    'ACC': 'T', 'GCC': 'A',
    'UCA': 'S', 'CCA': 'P',
    'ACA': 'T', 'GCA': 'A',
    'UCG': 'S', 'CCG': 'P',
    'ACG': 'T', 'GCG': 'A',
    'UAU': 'Y', 'CAU': 'H',
    'AAU': 'N', 'GAU': 'D',
    'UAC': 'Y', 'CAC': 'H',
    'AAC': 'N', 'GAC': 'D',
    'CAA': 'Q', 'AAA': 'K',
    'GAA': 'E', 'CAG': 'Q',
    'AAG': 'K', 'GAG': 'E',
    'UGU': 'C', 'CGU': 'R',
    'AGU': 'S', 'GGU': 'G',
    'UGC': 'C', 'CGC': 'R',
    'AGC': 'S', 'GGC': 'G',
    'CGA': 'R', 'AGA': 'R',
    'GGA': 'G', 'UGG': 'W',
    'CGG': 'R', 'AGG': 'R',
    'GGG': 'G' 
}

STOP_CODONES = ['UAA', 'UAG', 'UGA']


def dna_to_rna(dna_source: str) -> str:
    return dna_source.replace('T', 'U')


def rna_to_protein(rna_source: str) -> str:
    rna_separated = [rna_source[i: i+3] for i in range(0, len(rna_source), 3)]
    protein = ''
    if len(rna_separated[-1]) < 3:
        rna_separated = rna_separated[:-1]
    for cdn in rna_separated:
        if cdn not in STOP_CODONES:
            protein += CODON_TABLE[cdn]
        else:
            print(f'Found stop codone: {cdn}')
            print(f'Current protein string: {protein}')
            yield protein
            protein = ''

def molecular_mass(proteins):
    pass

genom_string = ''
with open('source_genom.txt', 'r') as source_file:
    source_strings = source_file.readlines()
    genom_string = ''.join([i.replace('\n', '') for i in source_strings])


with open('proteins.txt', 'w') as outp_file:
    proteins = [i for i in rna_to_protein(dna_to_rna(genom_string))]
    for i in proteins:
        outp_file.write(i + '\n')
