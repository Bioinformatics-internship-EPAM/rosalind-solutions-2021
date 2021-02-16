public class FastaEntry {
    private final String id;
    private final String description;
    private final double gcContent;

    public FastaEntry(String id, String description) {
        this.id = id;
        this.description = description;
        this.gcContent = computeGcContent(description);
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getGcContent() {
        return gcContent;
    }

    private Double computeGcContent(String description) {
        var cCount = description.length() - description.replace("C", "").length();
        var gCount = description.length() - description.replace("G", "").length();
        return (double)Math.round((double)(cCount + gCount) / description.length() * 100000000) / 1000000;
    }
}
