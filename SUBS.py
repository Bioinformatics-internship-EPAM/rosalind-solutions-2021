def main():
    first_dna_string = input('Enter first DNA string (make sure all letters are UPPERCASE): ')
    second_dna_string = input('Enter second DNA string (make sure all letters are UPPERCASE): ')
    indexes = []
    index = 0
    if len(first_dna_string) < len(second_dna_string):
        print('Second DNA string must be equal or smaller than first DNA string')
    else:
        while index + len(second_dna_string) != len(first_dna_string) - 1:
            index = first_dna_string.find(second_dna_string, index)
            if index != -1:
                index += 1
                indexes.append(index)
            else:
                break
        print(indexes)


if __name__ == '__main__':
    main()
