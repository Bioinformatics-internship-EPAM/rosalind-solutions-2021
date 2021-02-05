def main():
    first_dna_string = input('Enter first DNA string (make sure all letters are UPPERCASE): ')
    second_dna_string = input('Enter second DNA string (make sure all letters are UPPERCASE): ')
    ham_distance = 0
    for i in range(0, len(first_dna_string)):
        if first_dna_string[i] != second_dna_string[i]:
            ham_distance += 1
    print(ham_distance)


if __name__ == '__main__':
    main()
