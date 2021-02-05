def main():
    dna_string = input('Enter DNA string (make sure all letters are UPPERCASE): ')
    if len(dna_string) > 1000:
        print('DNA string must be less then 1000 symbols, try again')
    else:
        compliment_dna_string = ''
        reversed_dna_string = dna_string[::-1]
        for symb in reversed_dna_string:
            if symb == 'A':
                symb = 'T'
                compliment_dna_string += symb
            elif symb == 'G':
                symb = 'C'
                compliment_dna_string += symb
            elif symb == 'T':
                symb = 'A'
                compliment_dna_string += symb
            else:
                symb = 'G'
                compliment_dna_string += symb
        print(compliment_dna_string)


if __name__ == '__main__':
    main()
