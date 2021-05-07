# https://www.ncbi.nlm.nih.gov/nuccore/MT027062.1?report=fasta

CODON_TABLE = {
    'TTT': 'F', 'CTT': 'L', 'ATT': 'I', 'GTT': 'V',
    'TTC': 'F', 'CTC': 'L', 'ATC': 'I', 'GTC': 'V',
    'TTA': 'L', 'CTA': 'L', 'ATA': 'I', 'GTA': 'V',
    'TTG': 'L', 'CTG': 'L', 'ATG': 'M', 'GTG': 'V',
    'TCT': 'S', 'CCT': 'P', 'ACT': 'T', 'GCT': 'A',
    'TCC': 'S', 'CCC': 'P', 'ACC': 'T', 'GCC': 'A',
    'TCA': 'S', 'CCA': 'P', 'ACA': 'T', 'GCA': 'A',
    'TCG': 'S', 'CCG': 'P', 'ACG': 'T', 'GCG': 'A',
    'TAT': 'Y', 'CAT': 'H', 'AAT': 'N', 'GAT': 'D',
    'TAC': 'Y', 'CAC': 'H', 'AAC': 'N', 'GAC': 'D',
    'TAA': 'Stop', 'CAA': 'Q', 'AAA': 'K', 'GAA': 'E',
    'TAG': 'Stop', 'CAG': 'Q', 'AAG': 'K', 'GAG': 'E',
    'TGT': 'C', 'CGT': 'R', 'AGT': 'S', 'GGT': 'G',
    'TGC': 'C', 'CGC': 'R', 'AGC': 'S', 'GGC': 'G',
    'TGA': 'Stop', 'CGA': 'R', 'AGA': 'R', 'GGA': 'G',
    'TGG': 'W', 'CGG': 'R', 'AGG': 'R', 'GGG': 'G'
}

MASS_TABLE = {
    "A": 71.03711,
    "C": 103.00919,
    "D": 115.02694,
    "E": 129.04259,
    "F": 147.06841,
    "G": 57.02146,
    "H": 137.05891,
    "I": 113.08406,
    "K": 128.09496,
    "L": 113.08406,
    "M": 131.04049,
    "N": 114.04293,
    "P": 97.05276,
    "Q": 128.05858,
    "R": 156.10111,
    "S": 87.03203,
    "T": 101.04768,
    "V": 99.06841,
    "W": 186.07931,
    "Y": 163.06333,
}

def reverse_complement(dna: str) -> str:
    dict = {
        'A': 'T', 'T': 'A',
        'G': 'C', 'C': 'G'
    }
    res = []
    for i in reversed(dna):
        res.append(dict[i])
    return ''.join(res)

def map_codons(codon: str) -> str:
    protein = None
    if len(codon) == 3 and CODON_TABLE[codon]:
        protein = CODON_TABLE[codon]
    return protein

def get_proteins(src_string: str) -> list:
    res = []
    protein_map = []

    for index in range(len(src_string)):
        protein = map_codons(src_string[index:index+3])
        if protein and protein == 'M':
            protein_map.append(index)

    for index in protein_map:
        is_stop = False
        protein_str = ''

        for i in range(index, len(src_string), 3):
            protein = map_codons(src_string[i:i+3])

            if not protein:
                break
            if protein == 'Stop':
                is_stop = True
                break
            
            protein_str += protein
        if is_stop:
            res.append(protein_str)
    return res

def mass_count(proteins: list) -> list:
    result = []
    for protein in proteins:
        mass = 0
        for s in protein:
            if MASS_TABLE[s]:
                mass += MASS_TABLE[s]
        result.append({ protein: mass })
    return result


source_dna = ''
with open('source_genom.txt', 'r') as src:
    source_dna = ''.join([i.strip() for i in src.readlines()])


proteins = get_proteins(source_dna)
with open('proteins.txt', 'w') as prt:
    for protein in proteins:
        prt.write(f'{protein}\n')

proteins_reversed = get_proteins(reverse_complement(source_dna))
with open('proteins_complement.txt', 'w') as prt:
    for protein in proteins_reversed:
        prt.write(f'{protein}\n')

proteins = set(proteins + proteins_reversed)
mass = mass_count(proteins)
with open('mass.txt', 'w') as prt:
    for protein in mass:
        prt.write(f'{protein.items()}\n')
