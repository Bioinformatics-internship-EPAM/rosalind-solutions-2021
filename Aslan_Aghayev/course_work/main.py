DNA_CODON_TABLE = {
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

def read_fasta(path):
    with open(path, "r") as f:
        f.readline()
        dna = ''
        for line in f:
            # print('source', line)
            dna += line.strip()
    return dna


def map_codons(codon):
    protein = None
    if len(codon) == 3 and DNA_CODON_TABLE[codon]:
        protein = DNA_CODON_TABLE[codon]
    return protein


def reverse_complement(dna):
    dict = {
        'A': 'T', 'T': 'A',
        'G': 'C', 'C': 'G'
    }
    res = []
    for i in reversed(dna):
        res.append(dict[i])
    return ''.join(res)

def get_proteins(s):
    results = []
    protein_indices = []

    for i in range(len(s)):
        protein = map_codons(s[i:i + 3])
        if protein and protein == 'M':
            protein_indices.append(i)

    for i in protein_indices:
        stopped = False
        protein_string = ''

        for j in range(i, len(s), 3):
            protein = map_codons(s[j:j + 3])

            if not protein:
                break

            if protein == 'Stop':
                stopped = True
                break

            protein_string += protein

        if stopped:
            results.append(protein_string)

    return results

def get_mass(proteins):
    result = []
    for protein in proteins:
        mass = 0
        for s in protein:
            if MASS_TABLE[s]:
                mass += MASS_TABLE[s]
        result.append({ protein: mass })
    return result

if __name__ == "__main__":
    input = read_fasta('input.txt')

    proteins = get_proteins(input)
    proteins_reversed = get_proteins(reverse_complement(input))
    proteins = set(proteins + proteins_reversed)
    mass = get_mass(proteins)
    print(mass)
    print(len(proteins))
