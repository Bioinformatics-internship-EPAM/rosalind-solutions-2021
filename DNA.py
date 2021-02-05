def main():
    alphabet = ['A', 'G', 'T', 'C']
    dna_string = input('Enter DNA string (make sure all letters are UPPERCASE): ')
    a_count, c_count, g_count, t_count = 0, 0, 0, 0
    if len(dna_string) > 1000:
        print('DNA string must be less then 1000 symbols, try again')
    else:
        for symb in dna_string:
            if symb in alphabet:
                if symb == 'A':
                    a_count = a_count + 1
                if symb == 'G':
                    g_count = g_count + 1
                if symb == 'T':
                    t_count = t_count + 1
                else:
                    c_count = c_count + 1
            else:
                print('This is not a DNA string')
    print(a_count, c_count, g_count, t_count)


if __name__ == '__main__':
    main()
