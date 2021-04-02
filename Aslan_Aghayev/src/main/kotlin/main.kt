import java.io.File

fun main(args: Array<String>) {
//    lab1()
//    lab2()
//    lab3()
//    lab4()
//    lab5()
//    lab6()
//    lab7()
//    lab8()
//    lab9()
    lab10()
}

fun lab1() {
//    http://rosalind.info/problems/dna/
    val s = 		"CAGAAGGTGCGGTTCAATGTCTGCCTACAAAGTGAGATAATCAATGGGTTCCGCCGACTTATGATGATGGCTGTAGAGGTATTGAATTTCGTAGGTACATTCCACAGCGGACCACAAAGGTTAGGTTGCCGTGAGAGGGACGTATTGCATACGTGACGCTTTAAAGACGTTCGTTGACTATTTCTGAAGGTTACGCATAACTGGTGCTATGCTTATTTAGTCGCCTCGTAGCCGGGAGTCTACAATTTTATCCTATTGAGAAGCCACGCGCGACTACAAATCCGTTCAGCCCACTCTTTCAGATAAAAAAAATTTTAGGTTAGATCCATGTTCGGTAGACTCAGTAGCTTTCAGAGGTAACGCTTGATCCAATAGCCAAGGTGCACAGATTCTACTTAGTGAGTGACTGGGCCCAATGTCCCAAGACTACGGCTTGGGTTTTGTTAGTCGAGAGAACCTTCCTTGGCGCCCACCATGGAACTTCGTCCATCTGGACCAGCGACTGTGGATATGAGACAAAAAGACACTGCGGCTGCCAGTCTTTGAAAAGGCCCTGGTCTTACTGGTAGCGAGTCCTATGAGGCAAGGAAGAGCTAAGTCTAATGCCTCCGGGACTTAATGGGTAAGTTGGTGGAGAATCAAGAAGCGATACTCCCAGTAACCTCGCAACGCATTATTACAGTTTAGGTATCTATAGGCACCTACCTCAAATATGACGGCCCGGGCAACATATGATACATGGGATCTTTGTCGCATTCTACGTCCCTAATCAGAGGGCCGCCGATTAGTGCGATGCTTCAAGTTCTCGT"
    val chars = mutableMapOf(Pair('A', 0), Pair('C', 0), Pair('G', 0), Pair('T', 0))

    for (ch in s) {
        val value = chars[ch]
        if (value != null) {
            chars[ch] = value + 1
        }
    }

    println(chars)
}

fun lab2() {
//    http://rosalind.info/problems/rna/
    val s =
        "ATGAGGTGTCCAAAATTAATAGTACCTTTTCACTTAGGACGGGCCCTCTGTGTGCTTGTAAACGCTGTGATCTTGCAAGGTTACTCTTACGCCAACAGTTGGATCCTGCGGGGCTGTAGGCTAAAACACCACAGATCGCTAAGAGATAATATGTCCTGTGTACCCATCCCCTGCTATGCCATATTTATGTGGAAATTTATCCATACTTCAGCGAGGCTCGTTTCGTTAATGCCCCATGGTCCTTAATGTAAAAGGTTAACGCTGTAGTCGTTCCGAGGCGCTTAACATATAGTTCCGGCTGTGTTCGTTCTGCACGACGATCGGAGCTTTAAATATTTACATGAATCTAGCACTATGTGATGAAGAACGCGCTCAACTAGGCACCCCGTTAACCGCGTATATGATCACAATGAAGACTTCTGATCAAAAACGACACTAAATGATGGTTAGACGTAGGGTGCGCTTGCCTATGGTCGCTCCGGCTTCCATTAACTTCATCAGGACTAGACACTAAGTGCCCTGTTTAGTTATTTAATCCCTCATACCAACCTTTGACTCGTACGAGTGGGATCGACCGCATCCTATGGACACGGGATACGACCGACAAAAGAGACCCGGCCTCATTGAGATCCAAAAAATTACCAGCTTACTAAGCGTAGAAGTCGAATGATCGTTAGCCCACTGCACTGCCTCCATCAGCCACCCAGTCTAAGTCGTGAAAGGACATGCACGTGTCAGTATTCTATCTTGGGCGATTCCACTCGAAATCGGGCCAGCCTTCTGAGTTCGAATGTAGTAAGCCCTGAGAGCACTGGCCTCGCATCCGCGGTGGATTCTACTTATCAATTCAGCTCCGATGTACCCGATAAAAGGCCGGTTTTGCCGAGTATTCCCGCACTAGGTTTCTTAGTGTTCTACTGTTAGTTTTGGCTCCATAGATGGTCAGACGCTGACGCCCTGAACGCCCAAGATAGCCTTA"
    println(s.replace("T", "U"))
}

fun lab3() {
//    http://rosalind.info/problems/revc/
    val s =
        "TCTGCGTTTCGGAGTTAGGACGTACCCGATGAGGCTGCTTTTCCGAGAAGCAGAGGAGGCTAGGGAACATGCGGTGGATGTCATATGTCACACTCAGGGTACATGTTATTCCATCTCCTATAAGAAAGCGCCCGCTCGGTGCTGGATCTGCAACTTGTATAAAGTTCGGGAGCCGGTCCGTGCTTCGGCTGCTGGCATCTTACTGTCTATGTCCCGCCTCCAGATCTTGTCCCCGACAAACAAGTATTCTCCTTGCCGGCGGACGGCTTCTATAAACGGATTAGTGTGATATGCAGGGGTCGCCAATGTTAATGACCCGACTTTCCGCTTGGATAGCAAGATATCTGATTGAAAAGGGAACTTAAGGACCCCAACTATGGCGCCTCCACCGCGCTATAGGTGAGTCAGTATCCCTTGTGCTGGTGCACCAGGTTAATCTGCCGAAATATAGGCGTCCCGCATAATTGAAGAGGCTGTCGTTTTCTTTGAACGCAAGAATCCCGCGGGTGTCTTCTCAGTAGGGATGGACGCGCTAGGGCGTCGTTGGACATCGTGGTTGCGACGTACCGAGAGCTGCCTGCAAGGATCGGGTATTACTAGTAATGCTACACATTGTTCGAATCTCGAGGGTATAAGTGATAATCACGGTTCGGCTGTTATGCAGAAGGTTCATACCTCATCAGATCCTGCTGTGCGTTGGATGTCACGTCGGAGTTATATAGGGGGCTATTAGTAGGCAACGAACTGGATCCGGCCTTTTCCGTTACTAATGTTTCCGCCCTCCCATCACGAAGGGCAATCGAGTTAGGCAGTAAATTCCACTAGTCTAAAGAACGCTGTGCCATTGAAGGCGGTACATTCGCGATGTAGCACGTCCAT"
    var res = ""
    for (i in s.length - 1 downTo 0) {
        res += when (s[i]) {
            'A' -> 'T'
            'T' -> 'A'
            'G' -> 'C'
            'C' -> 'G'
            else -> s[i]
        }
    }
    println(res)
}

fun lab4() {
//    http://rosalind.info/problems/prot/
    val s =
        "AUGUUGAUCACUCGUGGGUUGGUUUCAGUCAGAAGAGCAUUGGGCCAAGUAAGAACUAGCAGAGCGUUAAACGGACUGCACGGCCGCCUCACGAGCCAACGUAUUCACAACGGGCAUCUAAGUGGUUUGAUUCUUACGCUUUAUGCGGCAUGUCAUCUUACCCCCGCCGCAUUCCACUCAAGCACCAGAGUCGAACCUAUAUAUAUAGGAAGCUAUUACAAUCCAAUAUCCAGCUGUCUUUUGGAUUACGGCGAAACUCUUCGGAACACUAACUGCACGAUCCCAGAUCGCACCGUGUCCAAUUACCCCAUUACAGGAUGCAAUCCAUCUCAGGCAUUUAUUCAUCGUAUAACCCUAGAAUUUCGGGGCUCCGGGUAUGCAAGAGUACACUCCCCCCUCGAUGUGAGGUCAGAAAUAAGAUGUUUGCAUUCAUUCAAUGCACUUCGGAUGGCUUUUCGGCCCUUUGUAAGAUACUCCACCAGAGCAUGGCGUAGUGCUGCAUAUGCAAACUACCGCGGCUGGCCCGGUAAAAACGGAGUAAAAAUCCUUUUUCUCCAGGGUCUCCUUGGUAAUUACUCAAUCCUCUCUUAUCGAAUACUCUCCGAAUAUCGUUAUGUUUCGCGACUAAACGUUCGUUCUAAAGCUGUCGAUCCUAGGAUUUCCGCGGCGCGCCAGAUCGCAGAUCUGCGCGGGUUCGUGAGGUGUGACGUGAUAGAAUAUUCCGGCUCAUCGAGCUCGAUGCCUGCGUUUGCGCGCAGGUCGGUUAGUCCACCAACAGUUAGUUCAUGUUACGAUGUGGUCCUUACGUCGAGGUGUGAUGCAAUGAGGCUACGUUUACGUACGAAUGGUGUAGGAGAAUCUCAAGCCACCUAUAGAAUCAGCGCUGGAUCUGGUCAGAUACGAUUAUUCUGUACUCACGCAGAAAUAUUGCCCCUACGCUCCCGUAGGCGUGCCUCCAUCCGCGCUAGCAGUGUGGUUCAGCGAGGGCCACGGCAGCGGACCCUAACGGUAGAGAUGAGCUGGCCACUGAAUUACCUAGUACCGGAGACGGAGACGAUAAUAUUGUACCGUCUUCUUAACGGCUCCGUAACAUCUAGUCGGAUCUGCUUGAGGGUCGGGGUCCCUGAAGCCGAAUACUGGCUACCACACUCCCAUGUGAUAACUCUAAACGAACUUACGUGGCAACAGCUGUAUAUUAUUUUAGAUCAGUCAUACGCGCUCACGCCAACUCAGGAUAGGCUGCCGGACGUAAUCCUGGCUUUUACACAUGGCUGUUCGGGUCCACAUCAGGAGAAACAUUCGAAAGACCCUAUACAGUGGCGAGAAUCCUUCCCGGUUGCCAAACAGUCGUCCGUUUGGUCGCUCCACGAACCAACUGCGUACGUGGUUUGGUUCACCAGAUACGUUGAACGUCGGGUACGCAUGGGACUUCAAUGUGUUACGAUAGUUUUGUUGUAUGGAGUGCGCCUCUGCGGCAAAUACUGUUAUACGGGCGUCGAUAAACGCGAUCCUAAUUUAAGGGUGAGCUGGUACAUAAUAUCGCGGGGCCCGCCAACAAGACGGAUGAAGUAUGGUCAAAGGGUCGUGGCUGUGGGUCCGAAUCAGCGACUGCCAGCUAGCCUGGGCCUGACGAGCGUCGCGCAUUUCUCCGUACCCAGUGUUUGGGCAUGUGGACUGAUUGAAACGGGGUUACUAGACCUCUUCAAGACGGGAUUAAGCCAAUGGCUUGCAGGCUGGGGUGCAGCCCUACGCAAGCAGAUACGGAUAUAUGCAGAAGUCCCUACCUGGAUUAUAGGUAACGCUGAAUCGAAUAGCAAGUGUGGCGAUGGAAGAAAGGGGUUCACCAACGACCUAGUUGUGAUGGUACGUGCCGAACUCAACCGCCAAUUACCAUGGAGACGAUCUUUCGAAAAUCGCUACAUCAGGCUUCCGUACGGGCUCGUCUCUGACAAUUUUGCAGUCCGCGUUCCAUUUUGGAGUAGAUCAGUUAUGCCACGUCCACUCCAAAGAAGAACAAGGGGGGUUAUAGUUAUCCCGAAGGCUCAUGCUCUGAGUCUUGUAAACUCAGCUUCCUUACAAAAUACCAAUUUCUUGAGGUCCAAAGACUGCAGGCUUCUCAUACGUGUUACACCCAAGCAGUGUCCGCUGGUCCACAGGCGUUGCACCGGCAUGAUAUACUCUGUCUCGACCUCACCGGCUCGAGAAUGCUCUGAGAACCGGAAGAUAAGGAAACUCGUAGAAGCCCAGACGUUAGGAGUCAAUGCGCGUAAGGGGCUCGAUGAGACUACAUGCAGGCGAGUUUUCUAUCCAAGCAUUGAUAACAUCUCUGAUGCUAUUCAUGCGGGUUGUGCUGAGAGCUGUAACCAAAUGAUCUUUCAUAGAAUGGUACUCCAAGCCCGUAGUGCCCAGAGAUUCCCAAGCCUUGAUUUCCAUACGCGCGAUAUGUGUCCAAACCCCGGGAUCGUUUUCCCAUAUGUAAUGAAACUGAAGACGAACUCGGUCUUAAUUGUGAACGGGCAGAUUUGGGAGGUAAUGCGGGUCUUCCGCUCCUAUCUCCUGACGUACCGUAUCGCUAAGCAUUCGCUGUCAAUGACACACGCUCCUACGCAUCCAUCGUCCAAGGUUGGGAGCUUGGCGAAUACGCAUGUAUGUCUAACUUCAGCUUCCUGUGUAUCUAUAUUUUCGCGAGUAGAACAAGAAAGACCCCCACACAAAACCAUUCAACUCCCUGGGGACCACUACUGGCUCGACGUUAAGUCAAGCGAAGUCGACAUGACAGAUCCGCUUACGCCUCAGCUGUACAGCCGGCCCGAUAAAGAGAUUAUUGUUGUCGACUCGAGCCCCAAUCCGAUUCAAAUUCCGGGCACGCAGUUCAAUUAUACAAGGUUUGUCGAUCUGUACAUCGCGCUCCAGGCGACAACCUGCUACGAGCCUGCACCAUACAACGUGCGCAAAGAAUGGCGCGCAGGGGUAAGGUAUCAGAAUCCAGCCAGCUUACAGGGCGACCUUGGUAGGACAUUCGGAGAGGAGUCGACUGGGGGCGGGCAAGGACGCUGCUAUGUUUUCUUUUGUACCCUAUAUUUACGGAUACGUGCUGAUUGCGUAUUCCCCAUGAUCUUUCUAGACUGGAUCUUAACGAUCGCCAGUGGUACAAGCUUCUCGCAACACGUUAGCAUAAGACUAUUAGUUACACUGUUUACGGUGGACGGUUGGUGGCAAGACGCCGGAGCUCUUCAGCUAAAUCUCGCGCGACGACGAUCGGUCGGGGACCUCGAGAUGUUAUUGGAAAAAUGCGGCUUCCUUCCACAGCGUAUAGCCAUCCCUACACUAGUGUGUAAUAACCCCGCUAGCUGCGAAGUCCAGUAUAAAUGGAAGGUAGUCUUUAAGCAUACCCUAUUACGUUUUGAUCCGUUUUUUGGGAGAGAAGGACAUCACCUCUCACAACUGCGUCGAUUAAGUAAUGCGACUCUUGGCUAUUAUUUACAGCCGGACGAGAGAACGCACUGUUCUCUUUUGCGAAUCUCUUGGCGAUCCCUACGGGUGCACAGAUUACAAGUGCAUACAGCUAUACUACUAGUCCAUUCUGUCCUAGCGCAAUCUAACAUGAAAUCUGUUAAAGGCGGCACACCGUCGUUGCGGCGAUACGGUGAACCUAACUACGCGGGGAAGCUAAGUGCGGUGGUUGGUUGUUGCACGCUCCGCAAAUGGGUAAUACCUACCGCAAAACGAGUGGCGAGCAGCGAAUUUGUGGCUGGCCGACGGCCAAUCUCUAUCUCUCACCUUUUGGGUGGCCGGGCUAGAGCCGGCAAUCGAUUGAGACCAACAGGAGCCCUUCUGCUGGCCACAAUCUUGGGUGCACUUCAAAUAGUGCAUAAAAUUGACCCCCAGCGCGAUAGAGAAGUAGUGAUUCCGAUAAACUGCGAGCGUGAGAUCAGGUGGUGCAUCCUAGAGGUAGCACAUAGGGUCAAAACCCUUACAAGAGUAAUAGCAGACAUUGAGAAUAUGUGUGGGUAUUGGUACACCACGAGAGCGGCCUGCUCUAGCACCUGUAUAGCCCGAAAAAUUCGAGAGUCCUCCGCAUACGUGAUUGGGCAGGAGGCGCGCCUAAUAUCUGCAAGGGCGGUAGCCGCACGUCAAAGAGGUUCAGGAAUCGCCGAGGGAUUCGACAAGCUCUAUCGGGAGGGGCUAACACUGCUCGGAACUGGUACUAGGUUUUGGACGAACCAGUAUAUCCUCCAUGUUUUUGUUAGGCCUACUGUCCGUACUCCAGCUAAGACAAGCAAGUCACCUUGCGCCAUGCCAUGCCAAUGCGCCUCGACACGGGGGGUUAGGGGGAACCCUAACCAACCGUCAUUGCGAACCAUCAAUUAUCGCAACGAUGUUAGGAAGUCAGUGCAGUCCGGAAGAGGUCUGUUACUGCCAAUAAUUGGCGUUACCGGAAACAGCGUUAAUUCUCAGAGGUCUAUGAUGAGAUUUAGUCCGGGAGCGAGUACCUUAGCCACGCGUUUGGGGUUUAUUCCAAUCAAGGGGCUCAACCUAGGAAGCGCAACUACAUUACUCCGAAUACGUCUCAUGAGCAUCUCCGCCCAAGGAACACGAACAAGAGCUGUAAGGUGUACGCAAGCCACGAUGGCAAAUGGUAGGCAUAUGGAAUACAUUAUUCGUACUAAGAAGUUAUGUAGGGUCAGUGAAUACGAACUCGCAAAUAAUUGCAGCCGUACCUAUUCUAUGGUUAAUGUGGGACAGGCGGCGGUGCAAAAAACCGGCCCCGGCUUGCAACAUAGGAGCAAUAUAGCCCCUUUUGUUCUGUUCAAAGUAUCGACCCCCUAUCCUCUUACAAUAAUAUAUCCGGGUAUGCUAGGGACACCUCUGACAGCUAUCUCAAUUCCGUCUUGGAAGUAUAUCCUCAUUACAAAUUCAACACAGAUUUGCGUCCUCAAACGGCAUUCUUCUCCCUACCGGCCGUGGGGGGCUGCUGCGAAGUGUCACUGUAAACGAUUUUGUCGUCAUACCGCUCAUGACCUACGUUCCUCCGGUCCAGGUCAUGUUGCAGUGCAACCAGGCUACUUCCGAGGACUCAACUCGACGGCGGAGGCCAGACGGGAGGAAACGGACACAGACGGCUCUGCUCAGAUUGACUUGGACUUUUCAAGACAAGAGACCCUGUUUGAAGUAUUGGUGCGUGAUGAAGCUCGGGCGCGCACGCUAAGAGGGAUUUCAAGUCGAUUCUGUGUUGCUACGGCGCAAAAGACAGUUCUGCCCGGAUUAGCCCGGGGUUCGGAUAGAACGAUCGCGGCAUGUUAUACAGUUCGGAACAGUGAGCAGGGGGAGACGGCUUUCCCUUUGACUAGCCCAAAUGCGCAACUUAGAUUUUGGGGGAAGUAUAGACUAGUACCGGAGUCACAAUUAGAUGCACAUUACCACGAUGAACGCGGUAGCCCAACGCAAGUCGCGGUUACAGACAAUCGGCCCGUUCGAGGAUCUAGAACUGUGCAUCACGUGAUCGUAUCGAGUCUAUCUAAGCAUGGUACGGCUAACAGCUGGCACGGCACGUAUCUACCAAGGGUAAUGGGGUUGUCGGAUUAUGCGAUGGGGAAAGGCCGCGUCAAGCACGAUUAUGGUACGUCGCGGCUUAGCCUUAAAAGAGCCAAAGUUGGACAAACAGAGCGCCGACAUCCAGCAGCAUCAUGCCUUUACGGGCCUCCCAAUUCAUGCGUCUCUGGUCCGAUUUCCAUAUCACAGACCCGCCCCAAGAUCGGGACGUCCUUCUGCCGAUGCUGGCUCUUUCGGUUUAUACAUUCUGUCCGGCCCUCGUACUUGGUACGUAAUGCUAGCCUCAGGGCGGGGCGAGCGUGUCCGUUACUUACAUGGCGGCACACCUGCUCUUAUUCAGUCUUUCGAUUUUCAGGCGCCAUUCUACAGGCUAUCCUGGCGCCUGAAGGUGCUGCCGCCAUCGUUCUGUCCAGUUGUCACCGCGUUGCUAAGUCGAUUACUCCAUCCAUCUUACUUGAGCACUUGGUCCCUGAGCACCUACCGCGCACUCCAUCCCAGGGACGAAAACACCGUGUGGGGCGAUUGCCACAAGGAUGUCAAGUUAUUGGGCACCCUAGCACUGGCAGCCGACAAAAGUGUGUUCUGGGGGCUUCCCAGGGCGAGCCAGGCACCCCCUCUACGCUUAAAAUGUCUAAAGAUAUAGCAGUUACUCUUCCAUGGCACUUCUUCGUCUUAAAAAUCCAGGUUCCGUUGUUCCUGAGUGUCGAUACGGUUCCCAGUUAUAUGUAUCUGAUGGCCAUCCGUGUUCGUGCAAAUAGCGUCACAACCCACACGUUACUUGGCUCUCACCGACCUGUAGAACAUGCAUUCUCACUAUUGAGUAAAGCUGUCACACCGUUUGGUAUAUGGUUUAUGAUACCUUGCAUCUGUAUAGUGACAUCGACUUUCGAAAAGUCACUCUGUCGCUCGUUCGAGUCACCGGCACAGCAGGCAACGCGCAUGUGUAGGCCCACUUUGUUAGCACGGUUUCAGGAUGCCGCCCUUCGACAAACGACAUACCGCUUCGCGUGCAGUAAAACCUGCAGACUCUUCUGGAAUCUCCGUAAGUGCACAUUCUACGCAGCAUUUUCUGCGCUAAAAGUGUUCUUAACUUACGCAGAGAGCGGACUAGUACCAAGCAGCUCAUGUUCGACCACAAGCGCCGGGGAACUUGCGAAGGGGUUUGCAUGUCUUUCCUGUCGUGGGCGGCCUCAAAUAGUUUCAGCCGUUGCGGCAAUCCAACUCACAACUACCUGGGAUCCGAGUGAGGAGCAUGGUUGCUGUGCGGUCUUCGUGGAGUCUUGGUGCGUACGCCGUUUCUGUGGGUAUAAUCAUCUACCGGUUCGACAAGGUCCAGAGUACGUGCUGUGUACUUUCCCACGGUCCGCCGAAAUUUGUCCACGGUUAAAGCUUCUGGGCGCUCCAUCCCCCUAUAUUUUGGCGCCCCAAAGUAAAUCAUACCGUCUCGGCGGAUAUAUACUUACCCCUGCUAUCCUACGAAAGAUCAUCGCGUGCGCAUUCCCAGGGGAUGACCCUCCCCCGGCGUCGCCGAUCGUUACGAGCUCAAGUGGGGGUCCAGCGCACAUUAAGCUAUCGAAAGACCACUGCUACUUACAUUCCCUGAAAAGGCAAUGUUCUCCCUUUCAACAGUUUUGGACCUUUACAAGCGGACGGAUCCAACCUGCGCGUCAAUCAACCACUGAGUACUACCCACACCAAUGGACUACAAUAAACCCGUUGAGGCUAGGCAGUGGGGGUGUUUUCAACGGCGGCAGACUUAAAGGUCAGUGGGACACUCCAGUGGACGGUCUUAGAGCAGCAGCCGGAUGGCUGGGAACUAUGACUCCCUCGAUGCGGAAUGACUUAAUUGCGAGUUUCAUCCCGACGGUCAGUCCGACUUGCCAAGUAGAGAUGGACCUGUUGCUCCUCACGGUUUAUUUUUUUUGUCAUGUUUUGCGCAACGGCUGCUCCUGUGUGGAAGGCCAGGAGGCACUUAAUGGGUCACCAGACUGGGAUACCACUAGAACUUGGAGGUAUUAUUUGGUCGUACCCGCCCCUAGUUUGUACCCAACGGUAGGCCACACUACCCCCGCAAGUGCAGCCGGCACGCCGGGUCAAGCCAAACAGACCUUAAAUUGCAUGACGGGAGCCUUCUACGGCGGAUUGGUGGCGCAUCCAUUUACCAUGCUAGCCAUCGCUACAGGAACGUUAAAAACAUCAUGGCUCACCAGUGAAGAGUUUCCGUCACCCGAUACGUCUUACAAGGUCCUCAGUCAGUACAAGCCGACAAUGUACACCAUUAAAUCGUGUCUCCAACGCCUUUCUACACCGUACGUUAAAGAAAGACUUGUGAGCUUUAUCAUAAUGUUGAAAUGCCGUGAAACGUCUCUGUUUGACUCCAAGCGUCCUGUUGGAGACCCCCUUUCCUUAGCGUUACCUACGCAACGUGGAUCAAAUAUGUCUGCGUAUCGCUCCGAUGAUAGAGUUAUGGUUUCAAAAACGUCUGAUAACCCACCUAACGAUAGAGUAACCUGGGGCUCGAACAAUACUAGAGGCAUUCUGCCUUCCGCGGAACGCGUGACCGAACCUUCAGAUAAGUGA"
    var res = ""
    val m = mapOf(
        Pair("UUU", "F"),
        Pair("UUC", "F"),
        Pair("UUA", "L"),
        Pair("UUG", "L"),
        Pair("UCU", "S"),
        Pair("UCC", "S"),
        Pair("UCA", "S"),
        Pair("UCG", "S"),
        Pair("UAU", "Y"),
        Pair("UAC", "Y"),
        Pair("UAA", "Stop"),
        Pair("AUG", "Stop"),
        Pair("UGU", "C"),
        Pair("UGC", "C"),
        Pair("UGA", "Stop"),
        Pair("UGG", "W"),
        Pair("CUU", "L"),
        Pair("CUC", "L"),
        Pair("CUA", "L"),
        Pair("CUG", "L"),
        Pair("CCU", "P"),
        Pair("CCC", "P"),
        Pair("CCA", "P"),
        Pair("CCG", "P"),
        Pair("CAU", "H"),
        Pair("CAC", "H"),
        Pair("CAA", "Q"),
        Pair("CAG", "Q"),
        Pair("CGU", "R"),
        Pair("CGC", "R"),
        Pair("CGA", "R"),
        Pair("CGG", "R"),
        Pair("AUU", "I"),
        Pair("AUC", "I"),
        Pair("AUA", "I"),
        Pair("AUG", "T"),
        Pair("ACU", "T"),
        Pair("ACC", "T"),
        Pair("ACA", "T"),
        Pair("ACG", "T"),
        Pair("AAU", "N"),
        Pair("AAC", "N"),
        Pair("AAA", "K"),
        Pair("AAG", "K"),
        Pair("AGU", "S"),
        Pair("AGC", "S"),
        Pair("AGA", "R"),
        Pair("AGG", "R"),
        Pair("GUU", "V"),
        Pair("GUC", "V"),
        Pair("GUA", "V"),
        Pair("GUG", "V"),
        Pair("GCU", "A"),
        Pair("GCC", "A"),
        Pair("GCA", "A"),
        Pair("GCG", "A"),
        Pair("GAU", "D"),
        Pair("GAC", "D"),
        Pair("GAA", "E"),
        Pair("GAG", "E"),
        Pair("AUG", "M"),
        Pair("GCC", "A"),
        Pair("GGU", "G"),
        Pair("GGC", "G"),
        Pair("GGA", "G"),
        Pair("GGG", "G")
    )
    val CODON_LENGTH = 3
    var prevIndex = 0
    for (i in CODON_LENGTH..s.length step CODON_LENGTH) {
        val new = m.getOrDefault(s.substring(prevIndex, i), s.substring(prevIndex, i))
        if (new === "Stop") {
            break;
        } else {
            res += new;
        }
        prevIndex = i;
    }
    println(res)
}

fun lab5() {
//    http://rosalind.info/problems/hamm/
    val inputStrings = """
>Rosalind_3412
GGAAGAAGGTAAGCCTTTGATATGAGGGCCCAACCTCTTAAGGTGAATGGCTGGCCAAAT
CCAAGTTCCACAAGGTATGGTAGCCTCATTAAGTAGGGTCGTAGGTTATGGGTAACCCCC
TTCACTCGCGCGGCAATGTGCAATGTAGCAACTACCAGCACGCTGCGTAGGTTGAAGATA
GCTGGTTCTCTAGCACGAGGACGGTGACCGACACAGCGTAAATAAATCTCGAGAATAGAC
TAAGTGATAATGTGTTTAGTATTTCAATCCGTCCCAACCTTTCTGGACATCCGCGTGTGA
CCTTGTGCCTGCGAGATTTGCGCGTCTAGCATAGAAACAGGGATCATATTGGGCGCATAA
GCTTAGGGGCCTTAACTATGAACATAAAATCCCCTCTTTGCGTCTGTTACCGTAGAGGTG
TCCAGTAGCAAATGGTTTCCATTTTCAGGTCATATATTACCAGGTAATTCGCCTCAGGTC
AACACTATTACGACAAGGAGCACAACACAGCTGACTTCACTCCATCGTCCTGTCTGTCGC
TAACTCCCTAATCGATTGAAACGATGGGAACAGATATGATAAGGTACGGTCTCATATACG
ATCCGTGGATAAATGGATTCACGTAGCTAGAGTTTTGACCTCATGCCGTGGAAGGGGGCA
AGGTGCCTTGAGGTAACGTGTTATCTCAACGGCGAAGAAGACCCGGTAAGGAGCTATCAA
CCCCTGCTGTGATGCCCTGTACAGTAGTAGGAGGTTCGATTATTCGGGAATAGGAATGCT
AGGCTAATGCTGGTAGCTCTGCCGACACTGCGCTGCTGCATTGTTATACCCTTGAACGCA
TAAACGCTGGTGTGTAACTTTTCGAGCTCCAGGCCTTAGGTGGGAGGGGGATCGTGATAT
ATTTTCGCTGAATAGCTACTTTCCCGTGTTTCTCAGCAATACGACTCCTGCAGAGGAGGC
TTGTGAGAGAACTCCAAAACGTCTAATGA
>Rosalind_0566
AGGGGGTCAGTACAGGGAACGAGGCTTGTTATGCTGTCGCGACGGCGTCGATGGGGGGTA
AGTCTCTTTCGTAGCTCACGTGACCATCTGCCCCACGTGGTAAAGCGGATATGCAACGGT
GTTCTTTTTCTCTGTTCGCCCTATAATGCGCTCCCCCTATTGCAGCAACCACCATCCGGA
TGGCCATCTCTATACCTCATTCTCATGCATGGTTTTACGTAATGCGCATATTGCCGCTTT
CATTCCCCGCCAGCTCTATGTCACCTAGTCACGCACGACGCGCAAAACATAGTACTGCGC
TAAAGGCATGGGACGGGCTCCATGGACGGGAATTTGCAGGACGACACATTCGGCTACCGC
GTGGCGGCCTCCTGAGAGACGGGACCGCCTTCTCAAATGTCCCATTCAACAAGTGTATCT
GCGATAGTATTCAGTACGTCTTGGGTGGATAAACGCGCCACCTAGTAATGAAGAGGTACG
CTTCGAAGAACACTCCGTGTTACTTCCTCTGAACCTGCGATGCGGCTATCTTTACTTTCC
ATCCCATTACAGGGAGACTCGGCCCCTCCTACGCCAAATGCCCCCGACGACCTGGTGCAT
GCGTGCGTGAAGAATGATCTGACCAGCCATCCAAATATATCGCCAAATAGCCCTCGCAGT
TTGGTCTAACAATCATTTCCAGAACGTGTGACCCATGGGACCAGTGAATGGTAAGATTCA
TGGACGTGGTCCAGAGGATCCGCCTCTGTGCCATTCCCCACAGTGGCAGGCATCTCCATT
AGCCCCTCAAGACTTTGAAAGCCTTTGCTTATTTGCGCATTTAATTAGAAGGGTGCAGGA
ATGCTAGCCTGTCCCGGTACTCTAATTCAGTACAGGCTCTTCATCGTAAACCTCTTCCCA
ACCATAGATTGGGGCTTAA
>Rosalind_3404
TAGTGTGGATCTGCGTCGTTACGTCACTCAGGGAAACCGCCGAGATCCCTGGCGTTATAC
GCTGGGACTACGCTTGCTCTCGTTGGTTATGGTCGCTAACCACCCGTATGCATAGGGTAT
TGACCGACGTCTCCTGAGGGTGGCTACAACATCATAATAATGTAACGTGAGATCAATTCC
CACAATTGTTGTGAGGAAGACGCACTCATCAAAGGGTAACAAACGCTTATATGGAAGTCT
TTCTAGGATCCGCTTATATCTCCCCAGGATGTGAGCCGCCTGGCTGCCAGAGCGTGTTGT
GCCACGAAAGTTTATATACGTCAAAAACTTTCTCCCGATGATAGCTTGAGTGTTCCTTCT
CCGAAAAGAGAACGTAGCCCTCGACTAGCACTACTACTCACCGTTCAGTTCATCCTGTTC
AACGACCGTACAAAGACTTTCGGTTTATCTAGCGTGGGCCCACAAGAATATCTTGATATT
ATATCTGCCATGCTGTAGGCCGGAACCAGGTTTCTTTAAGAGGCGTAGAGGGCCCGGTAC
ATAAGGCAGCAGAGTATGCCCGACGATGTCATGTCGTCAAGATAATAAGACATTGAATCA
CTTTAGCCTTCAAAGTAGCGTGACCTTGGATCATTTTAGTTCGTTGCGCTTACTTCATTT
TATAGCGCCCGATTGTCGTACGTGCAACTATGTGCAGAGAAGTTAAGTGTTCCTTACCGA
CAAGGCGTCAGTATCACGGACATAACCCGGAACCAACAAGTAGAGTCGTCACCGCTTTGG
GTTTGCGCATGACGGCAGACATTTAGCGGTCCAGTACATCCTGCTGTGGTTGTATTCAGA
GCCGGAGGTGCCCGAGGTGCGGAACCTCACTCAC
>Rosalind_4938
CTATTGTTAGGTAACTAGCTTCGGTATGCACAACATGGCGACCCCCGTCAATATGCCGGA
AGTATAAATGGTACTACCATCTAGTCTCCCACTTTATACAGGGGCACACCCTCCCGCTTC
GAGGGGTCGTACTGAAAGGATGGGATATATGAGCTGCGGTGAGCGCCGGCTCACGCCCCG
CACAGGGGCAGGTAACGTCAGCTAAGAAACCAGAAGAAAAGAGAGGAACGACAGCGCGCG
TGATTTGTAAAACAAATGGTCCCTGACGACTTGAATTCCAGCGAGTCATCTCATTTCTTT
CGTAGTTATGCGATTCAATTCGGCGTGTTGCGTGCATTGACTGCGTGGGGAAACTCCTAA
GAGCTTGATGGAGGGGTCTCGCGCGATGAGAGCCGGGTGCTCAATAGCAACCCTGATTTG
GTACCGGCCCAAGGAAGGCATACAACTCAGAGTGGCCATCTTCAAGGAGACAGAGACCAA
TCCGGACCTTCTTGCCCCCATAACGAAGATAAAGAGAGATTCTGATAAACAAAATCCGGC
GAGAGCCCTACGCTACCCCTATCAAGGCTGTGACACCAACCTCCATTGGAGACACCTGAT
CACCGCGAGATGTACTGATTTATATGGCCCTCTTATAGCGGTCGTATTACCACTTAGGTG
TGGGTATATCCGGCATGTGTCTTCATACAGAGGGCTGGCAATATCGTTAAAGCGTCCGTT
TAGGATACACGACGTTTACCAGCGTACGAAAGTCGTAGTGCGGATTCAGGAAGTCTTTCC
CTCGCGACGCCCACATAACCGCCATATGAGACCGATAGGACCTATTAAGATTCCGTGAAC
CGATGAGACTGTTCAACAAATATTCATGTGATTCAAGGATAAGCTGCGACACATTGAAAC
TGAGTTGGAAGCTCCCTGACTGAATGTGTGAACTACCGTAGCCCTTCGCTGTA
>Rosalind_5769
TAGAGTCTGGAGAAATGTTCGGGAGCGGTAATTAGGTCGCGGCCTTACGGGTCGCAGTAC
TATTACACGATGGACTAGACTCCTTCATGACACAACTTGTAAAGAAGACATTAGTCGTGA
AGTCGCTGGGGAAGTCAGCCTGCATCGTTTACGATTAATCGCCTAATCTACGTTCTTTCA
GCCGCTCTCCCACCGATTATATTCACCTAGCGGGATGCCCAGCCGATGTTGATGTGTTGA
GGTGCTCTGGGAGACGACTCATTACCGTAACTCAAGTGCTATAAGTGTCTAACAAACATG
TGGAGGAATTCGCAAATAGCGTGTCAATTCTATTATGGCCCAGGGTCCGGAACCTGTGTG
GTTGTGCCTGGTAAATAACTCCATGCCGACTTAGCTAACGAGCGTTAACGCGCCTGACGG
CGGCGCAGACCAGCTTCGGTACCTCGGAGGACCCACTGACCTTCCTTCCGGCCCACGGGC
TTTACGGACGGCGAGTTTGGCAGAGGTATCGTGTGTTGTGCTCATCAGCTAACAGCTCCC
CACGTCTTGATCGGCGGAAGGCCCCTAGTAGGATTCTACTCTATATGGCGGACCACACCT
GACTGCTGGATCTCCGCACACGTGGAGCTTCCGGAGCAGTCAGTGTAACTATGACAAATT
GATATGGTTAATCCAGGAACCGATTGCGCGAAACTTATATTACGTTTCGGGACAAGCCAG
TTAGCACTGCTATTCGCGCATGCCTTATAAGGTCTGAGGCCCTATAAAGTGACTTAGGTT
GCCATGATCTTCCGGATATTGTTGTAACTAGCCCCGGCTAAACTCTACTAGGCGAATGGA
TTTGATGCCCTACATGGCAAATGGCTAATCGAGGACGGCAGCACAAGGTGCACGGCTGAG
TCTCGTTA
>Rosalind_3979
CTGTGTTGGCTTTACTCTGCACCATTCCGGTAAACAACAGAAATCCAAACATACTGGCGG
GAAATTAAATGGGCTATCCGGCTCCCCTTGTTTTTCAACCCGTTAGTGCACCGAACAGAA
CCCCGGCCGACGAGGGGCAGGGCTCACGCTCTGCTGGTCCGGCCAACTCTTCGGGAACCT
GCACTAAAATGCTGGCGAGTCTTATATCTAACGGATAACCAGGCACCCCTTCTTCGAACC
ATACATCCAGAGGCTAAAATATTATTGTTTACCAGAGCCATTGTAGGTTCCAAAACTAGT
CTCAGCTAATTTCCCGGTAAACCATTTCTTGGGCGTTGATTAGAAAAACGCGTACTACTT
CTCTCCCCAACAGATCGGCTGATACGCAGGTACCGGACAAGCCATTCTGATAGCGGCTAA
TTCTGGGGGGCAACTAGTAGTAGATTATAGCTACACGAGAATAGATTTGCCGAAGACGAG
CTCAGAACTTATGCGCAATAAGGTTATGCTCCCCTTAAGCTAGCCAGTAAGAGCGTGGGG
CGTCTAGTGCGTTTGACATGTGACGTGAGCAAAAAGGGAAATCTTGGACTTAGGGTGCTG
TGGCACCTGTAAACTGCGTTTTCTGCGCGATTCGACTTAGTTCTGAGTATTAAGCGGCCT
AATACCACTTCTTAGACACGTCATACCGCAAGTCTCCTTATCATAACTGAAATTACGAAG
TGACGAAAGCTTTGGTTACATATCGGCTGGGTCGTTACTCACTAGAGGCTGAGTTGAGCT
CAACACTCCTAATAATCTCCATGCTCTCTCCAGAGATGGGGGAAATGGAGATTGTCTTTC
GCTTCATGACCACAAGTCCTAGCAACCTACAGGTACGAAACCTTGCCTACTAGTGGGTCA
CACCCAGGTCTCCGACGCACCCCAATCTGGTTT
>Rosalind_3167
CTTTTACGCGAGAGCGAGGTAAGCTCGTCTAGGACGGTCTGGACCTTTTGCGAGCATAAC
TTGCGAACAGCTCGCATTAGGGCTTCCTAAGCCGGGAACCCAGGGGCACCACCGCCACGC
TTACGGCGTCGTCCGTGGAAGTGTCCTTTGCTTGTTTCCCGCGCATTCATCATATTAAAG
GGGTTCCACTTTTCTGCCGGTAACCGTATGTCGCACTAGACGTCTTGTAAGACAATACTT
CCCTAGCACGAGCTGGGGAAATTGGCAAGGACATCGCATAATCTTCCTCCGAACCGTTGC
CGGAGCCAAACGAACCTACGTTGGAGTGAATACATTGTCTTATTGATCTTCGAGTCTGAA
TTGGTATCACGCAGTCAGGTGGCCGGCGTTGCGTCTCCAGCTACGGGGGAGACAGACCTG
TACGAGGGTGACGGCCCTCTCTGGTTGGTGGTTCTTTTACACAGGATGTCGTTACGATTG
TAGGCAGGCGGACATCGAATATGATCTGTGAGACGCGCCAGTGAACACCGCCTGGTAGGC
CTTTCGGATCCCTTCCTCCATACCCTTAAGCCCAGTTAGTTAGACCGGTCTCCACAGGGT
TGAGACTTCAGATTTCGACACCGGCCGTTACCAGAACGTCTGTTCCCATATTAATTAGTT
TCACCCCTCCCTATCCTTCGCTCACGCTCAATGGTCCAGCTTTCTCAACCCCAGCCGACG
AGCGTATATTTAATCAGGCGGGCTCTTGCCCTTACTCGGTCTCCACGTAAAGGAAGGCTC
GACCGGGTCTGAGGAATGGCGGCCAGTAAACTTTGACACAGCAGATCGAGTCTTGTTCCC
CGGAAAAAGTTGCGGAACGAGAATAACGATCGCTACAGGCAAGCAAGACTTAGGAGATCA
>Rosalind_4181
CAGTGTGCTTGCTAGTGTCCGCTCCGGTGTTTTACAGTCAGCGACGTAACTTCTGTTAGC
CAACGGTGTGGTGGCGAAACGTAGAAGTATACAACGCCAAACCCGGCAGCGCAACCCCGC
GCATATTAGTTGACGAGAGTGTATCGCATCCAGGTTCAGTTTGCGGAACAGCTTGTGGGT
CTAAAGCTATGCTGGCCATATATCTGGCCCAGGAGATTTTGACGACATCCTATAAGCTGT
ACGGTGCGATTATCTTCGTGTCACGGATTACTGATTTAGCAATGGTATGTGAGCGACATA
TCCCGCTCGCTAGCCTCAGCCGTTCTGCAATTAGGAAGAGTACGGTGATCATGAGGGTAC
AATGTAAAATGTTCCCGCGCTCTCTGCCACACTGCGAACCCATCGTAAGATAATACCCCA
GAGGGCCAGTGTGGGCAGGTCAGGAGTGGTCACGAAGGGTGGGTCCATCCGATCGGACTT
CGGTCTCCAATAGGGTGCAATGTCCAAACAACCTAGTTCGCAGCGACGCTGAGGTGCTTG
TTACTCGGAAGTCTGTCCTTTCGCAGGCTAGACAGTTACGATATGAGGGTCCAATCAGCA
GATTCCAGTTAAAGCCCTGGGGTATGCGTTGTGTTAAGGGCCCAGGGGTCGCCCGTCGTG
TGCGATGTAAGGGAGATCAGAATGGGTGGGGGAAGTTAGTACTTTGAAAAGGATCAGTAT
AAACGAGTCGGCTAGGACCCCCTCTGGCGCCCGCTATTACGAATACCGTGCATTGGAGCT
AAATGGGACTAGATACTGTTGTACACCTCCAAACGAGTATAAGGCGACCCGACGTCCTGC
CAGAAGGGACGCAAACCCACCCTATAGAATGAGCGGTC
    """
    val stringsWithIds = inputStrings.split(">");
//    println(stringsWithIds)
    val strings = arrayListOf<String>()
    val ids = arrayListOf<String>()
    for (si in stringsWithIds) {
        val splitted = si.split("\n");
        if (splitted[0].isNotEmpty()) {
            ids.add(splitted[0])
            strings.add(splitted.drop(1).joinToString(""))
        }

    }
    val chars = arrayListOf("C", "G")

    var resId = ""
    var resCount = 0.00000

    for (ind in strings.indices) {
        val s = strings[ind]
        var num = 0.0000000000

        for (al in chars) {
            num += s.count { al.contains(it) }
        }

        if ((num / s.length) * 100 > resCount) {
            resCount = num / s.length * 100
            resId = ids[ind]
        }
    }

    println(resId)
    println(resCount)
}

fun lab6() {
//    http://rosalind.info/problems/hamm/
    val s1 =
        "TGGTCACCTCCCAACCCTCGTTCACAACTTTGGCTGCGACCTACCCCAAATCCTATGTGAAGAAGGTTCCACAACACACAAGCACCAACAATCGCTCCTGTTAGTCGTGCGCGGATTGGAATATAAACTTCTAGCATTGGCCGTCCTAGTATCGGACGATGGTTTATCTCGATCATGGGAGGAGGCAATGCAGAAAGCATTTAATTTCAGCAAACTTTCAGACGCCGGAACCAAGATCGTAGATGTTCTTCACAAGCGATAACCGTTTCTCTACCTTGAGACCCGGGAGAACCCACATCACTCTGTCCCCTGTTTCGGTCACCATGCAGGTAGTGCCTGCATAGTCGCATCGCACCTATGCGACTATTCGAATTATCCGATTAGCTCTCAATTGCGTTGTCCCTAGTGCGTGAATAGTTTAGGAAATTGACCCCAGGTCCGGTTTCAATTGCAATACTTTGGTGACCCACATTTGATCCAGGGTGCGCAGACCATGTGAGCGCGGAATGCGTTTCTCGAATGTCAAACGAGTGTCACTTTAGCCCCTCTATTGAAGAACTGGAAATTGCTATGCATGATTGGTCAACCCCAGGTAGCAGTTAGTCGCTGCGAGCTCCCTTGGCGTCTTCCACTGCTACGGCTTAAAACTGGACGCATAAGTTCTAAGGATCTATCTCGTAGACGCTAAATTCAGACCGCCGCGGCAGAGTGATAGACCGCAATACGAGTTTAGCCCGTCCTATGCTCACACTGACTACGAATAGAGCCGCATGTTTCGTCAAACTTAATTCCAGAAGTCCAGCTATCATCAAGCCGAGTCTCAATTAGCCTAGCGCCTAGCGCCGCACCTCATATCCGAGAGTCAAACAATCTTCTATCTTCGCATTACCATACAGTCCCCCGCATACCTATCGTAACAGATGTGTCCTTTTTCACTCTTTGTTAGAATGTGCGAGTTACCTG"
    val s2 =
        "AAGACGCGCGATATAACACCTACCTAGGTTTCGCTCTGCACTTCCTCCGACCATAGGTGGCGGTGGTCTCTTAGTACCTGTACATCACCGACAGCAGCTGACAGTCCAACTCTGCCACGAAGACTTAAATCACCCACCATTAGGAATGGTATTACGGCGTGCTTCATCTACACCATCGGCACGCCCTATGTGGTGAGCCATTTATCGGAACATATTTTCAGACTGCGGCACGAAGAACGAAGAGATTCTCCAAAAGCAAGTACTGTGAGTAGGCTGTGCAGCGAGTGTCACGGCAATGCGGTTTATTCACCCTACGATTCCGCATCGAGATAGAGGTAGCAGTGTACGAATACTCACATGTGTATATTCTTAATAGCCGAATCAGTCAAGTCTCGGTTGTCACCGGTAGGATAAGAGTCCGGTATACTCAGTGGAGGTCATGTTTAATTAACAATCCGGCGGTGACTGAAACTAGATGCGCTGGCCCAAACTCTTTGGTGGGCTTCATGGCAGGCAGGATAGTCGAATGCGAATTCCGGCACCCTTCATTCCCTATTCCTCTTCAATGTAAAGAAAGGATGGCTAGCCGTAGGCAGAAGTTATTCATGGCGGGGTCGCTACACGGATTGCATCGCACACAGTAAATCCGAGGTCCCTCTGCTCCAAGCAAGTATCGCAGAGACGCTAACTCCAGCAATTAGCGCGAACGTCAGATGTTTCTGTACGTTAATCGGACGGACTGAGATCAATATACGTTCAAAGTTTCGTGAATGACAAGCCGCACCTTGTGGGAGGCTGACTCCGGTCACGTAACTCAGTCAGAGACTTCTCAGTGCATGGTACCTCACGTCTCGTCTGCGAGGCAGCAAAGCGCCCTTCTAGTAAATCTCTTACTGGCCGAGGCATCGCTCTTCTGACTGATGTGGACCTGCTCTCTTGTAATCTCAGAAAGGAGACTGATGG"

    var res = 0
    for (ind in s1.indices) {
        if (s1[ind] != s2[ind]) {
            res++
        }
    }

    println(res)

}

fun lab7() {
//    http://rosalind.info/problems/iprb/
    val s1 =
        "AGGGATCAAGGGATCACACCTGCTAGGGATCAGGGATCAGGGATCTCATATCAAGGGATCCAAGGGATCGTTAGGGATCAAGGGATCTCAGGGATCTTAGGGATCATAAGGGATCATTGCAGAACAGCAGGGATCGAGGGATCACGAGGGATCGGGAGCGTATGTCTTTGAGGGATCAGGGATCTTTAGGGATCACAAGGGATCAGGGATCATAAGGGATCTTATACACTAGGGATCAGGGATCAGGGATCGGCGGGGTAGGGATCTAGGGATCAGGAGGGATCATGAGGGATCCCGACTAGGGATCCGCTGAGGGATCTAGGGATCAAGGGATCATACCGAAGGAGGGATCATTACGGAAGGGATCTAGAGGGATCGGTTAAGGGATCAGGGATCAGGGATCAAGGGATCCCCGTATGAGCGAATCTAGGGATCAGGGATCCGTTAGGGATCCTGGCCGAAGTGAACAAGGGATCAGGGATCCGGCTAGGGATCACGCACAATTGACGAGGGATCACTGAGGGATCAAGGGATCAAGGGATCAGGGATCGAGGGATCTAAGGGATCAGGGATCAGGGATCTACAGGGATCTGAGAAGGGATCTAAGGGATCTAGGGATCGAGGGATCTAGCAGGGATCGGTCCCAGGGATCAGGGATCGAGGGATCCCAGTTGTCTAAGGGATCAAAGGGATCGCAGGGATCAGGGATCAGGGATCAGGGATCTAAGGGATCAGGGATCTGGAGGGATCAGCGACAGGGATCTAGGGATCACAAAGGGATCCAGGGATCGCAGGGATCCACTGAGGGATCGCACGAGGGATCTAGGGATCAACGGAGGGATCAGGGATCCTAGGGATCAAGGGATCAGGGATCAAGGGATCATCGGAGGGATCAAGGGATCAGGGATCGAGGGATCAAGGGATCAAAGGGATC"
    val s2 = "AGGGATCAG"

    val res = arrayListOf<Int>()
    for (i in s1.indices) {
        var endInd = i + s2.length;
        if (endInd > s1.length) {
            endInd = s1.length
        };
        if (s2 == s1.substring(i, endInd)) {
            res.add(i + 1)
        }
    }

    println(res.joinToString(" "))
}

fun lab8() {
//    http://rosalind.info/problems/prtm/
    val s = "MVHWMICTWHHILGGKAWGNWNAGHQYEMETLCFWWCDHNDIAMHQGPKIHKSRKGHKNAGAVRMSWPPKLMELSQLGWFWHCEAMKMKYKMNLYMFNYRYERLGFYVDVWPSFCMTVCVLSLYTWFFQQDLDCQIAMTPLPDQQCIDDALVRGPCYITRNDMQICADTVNLYQTKRMVQVMKELSYKIMCEGCMVKYEIDALREVIIVKFVCGWQRRHYPCCQTYLAHHTQMCVDPAFSEWWDIGRRQNDCKPHCQMIGSPHVIMLCRNFCLRKQFAQFMEPISHPCKVEMAIGDLSNKQGSFRHSQWFVWKSIQMGITCHNQDYSTLHFDMLQGQPLSHGRESKYGPCSPAGNMGRFNGLLKVDKIGRIAPWAETKYTPHDQMYRLDYFQQLNFQKWSIFGTPMKTLCQHFDQPMYFFSYRLWDSWILTVPLHRGNPHLHTVLCYNWCCRRIAACEMQVQAGLHNDAWKGIKNPMYPWFQELSKKVWTIGGADYEGSDSCAWSLTAIFRLRWSRPHKYQYEAYMPMRMYLYKDFEGQYWFKGIMHNGYHAPPVAHQDSNPLCWEIYEQRATAGMNGYWETIKNMDGWLEKPCDQGDNASVRRPCSHQTCRMHVSWPWMFGIAYECQEVVVITVIANKIYAPGPCTPWEDMRLWADCIGYWWCWHNSWHCITRDSWYLMDKFMPQTANICQEYANKGCCVYMLVLNLKEAHKGYHSLVFLVHITPMISESWQRKMLDNMCGQQMHDVLCPMWRFQLAADSMTIMMEACEDLDVDIKLASKWVITSSDSLFIPEWVDCDWTCRFGHIFKADFCNGCEIREWLDYDWQSPNNITERCDTIFHLNCPIYPHIRNFLEHAKGDKEVFMKWWQGPWMWAYCFEKMRFFRSCFWTAAYTHPWLFSITDA"
    val m = mapOf(
        Pair("A",   71.03711),
        Pair("C",   103.00919),
        Pair("D",   115.02694),
        Pair("E",   129.04259),
        Pair("F",   147.06841),
        Pair("G",   57.02146),
        Pair("H",   137.05891),
        Pair("I",   113.08406),
        Pair("K",   128.09496),
        Pair("L",   113.08406),
        Pair("M",   131.04049),
        Pair("N",   114.04293),
        Pair("P",   97.05276),
        Pair("Q",   128.05858),
        Pair("R",   156.10111),
        Pair("S",   87.03203),
        Pair("T",   101.04768),
        Pair("V",   99.06841),
        Pair("W",   186.07931),
        Pair("Y",   163.06333),
    )
    var res = 0.0
    for (c in s) {
        res += m.getOrDefault(c.toString(), 0.0)
    }
    println(res)
}


fun lab9(): String {
//    http://rosalind.info/problems/lcsm/
    val input = {}.javaClass.getResource("lab9.txt").readText()
//    println(text)

    val stringsWithIds = input.split(">");
    val strings = arrayListOf<String>()
    for (si in stringsWithIds) {
        val splitted = si.split("\n");
        if (splitted[0].isNotEmpty()) {
            strings.add(splitted.drop(1).joinToString(""))
        }

    }

    var sortedStrings = strings.sortedBy { it.length }
    val shortStr = sortedStrings[0]
    sortedStrings = sortedStrings.drop(1)
    fun getsubStrings(str: String): ArrayList<String> {
        val substrings = arrayListOf<String>()
        val n = str.length;
        for (i in 0 until n) {
            for (j in i+1 until n) {
                substrings.add(str.substring(i, j))
            }
        }
        return substrings
    }

    val substrings = getsubStrings(shortStr).sortedByDescending { it.length }
//    println(substrings)
    for (substr in substrings) {
        if (sortedStrings.all { it.contains(substr) }) {
            println(substr)
            return substr
        }
    }
    return ""
}

fun lab10() {
    val k = 29.0
    val m = 24.0
    val n = 23.0
    val p = k + m + n
    val prob = (4*k*(k-1)+3*m*(m-1)+4*(2*k*m + 2*k*n + m*n))/(4*p*(p-1))
    println(prob)
}
