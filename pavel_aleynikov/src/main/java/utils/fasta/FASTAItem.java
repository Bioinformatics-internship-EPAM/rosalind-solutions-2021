package utils.fasta;

import java.util.Objects;

/**
 * Item read from FASTA file
 *
 * Item contain:
 *   label - without `>` char
 *   sequence - label related string
 */
public class FASTAItem {

    private String label;
    private String sequence;

    public FASTAItem(String label, String sequence) {
        this.label = label;
        this.sequence = sequence;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FASTAItem fastaItem = (FASTAItem) o;
        return Objects.equals(label, fastaItem.label) && Objects.equals(sequence, fastaItem.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, sequence);
    }

}
