package ru.spbstu.shakhmin.utils;

public class FastaBlock {
    protected final String id;
    protected final String description;

    public FastaBlock(final String id, final String description) {
        this.id = id;
        this.description = description;
    }

    public FastaBlock(final FastaBlock fastaBlock) {
        this.id = fastaBlock.id;
        this.description = fastaBlock.description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
