def main():
    dna_string = input('Enter DNA string (make sure all letters are UPPERCASE): ')
    if len(dna_string) > 1000:
        print('DNA string must be less then 1000 symbols, try again')
    else:
        rna_string = dna_string.replace('T', 'U')
        print(rna_string)


if __name__ == '__main__':
    main()
