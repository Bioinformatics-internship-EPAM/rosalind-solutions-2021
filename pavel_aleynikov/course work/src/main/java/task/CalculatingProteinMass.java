package task;

import utils.Constants;

/**
 * Calculating Protein Mass
 * <p>
 * http://rosalind.info/problems/prtm/
 */
public class CalculatingProteinMass {

    /**
     * Calculating Protein Mass
     *
     * @param protein - string contains chars from amino acid alphabet
     * @return - protein mass
     */
    public static double calculate(String protein) {
        double mass = 0;
        for (int i = 0; i < protein.length(); i++) {
            mass += Constants.MASS_TABLE.get(protein.charAt(i));
        }
        return mass;
    }

}
