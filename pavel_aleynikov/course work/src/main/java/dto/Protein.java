package dto;

import java.util.Objects;

/**
 * Protein find in RNA
 * <p>
 * Item contain:
 * name - protein name if exist, or UNDEFINED
 * startIndex - index of start codon in RNA
 * stopIndex - index of stop codon in RNA
 * sequence - protein sequence
 */
public class Protein {

    private String name = "UNDEFINED";
    private int startIndex;
    private int stopIndex;
    private String sequence;

    public Protein(String name, int startIndex, int stopIndex, String sequence) {
        this.name = name;
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.sequence = sequence;
    }

    public Protein(int startIndex, int stopIndex, String sequence) {
        this.startIndex = startIndex;
        this.stopIndex = stopIndex;
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
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
        Protein protein = (Protein) o;
        return startIndex == protein.startIndex && stopIndex == protein.stopIndex && Objects.equals(name, protein.name) && Objects.equals(sequence, protein.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startIndex, stopIndex, sequence);
    }

    @Override
    public String toString() {
        return "Protein{" +
                "name='" + name + '\'' +
                ", startIndex=" + startIndex +
                ", stopIndex=" + stopIndex +
                ", sequence='" + sequence + '\'' +
                '}';
    }

}
