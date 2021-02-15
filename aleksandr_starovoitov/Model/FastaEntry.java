public class FastaEntry {
    private String id;
    private String description;
    private double gcContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        computeGcContent(description);
    }

    private void computeGcContent(String description) {
        var cCount = description.length() - description.replace("C", "").length();
        var gCount = description.length() - description.replace("G", "").length();
        gcContent = (double)Math.round((double)(cCount + gCount) / description.length() * 100000000) / 1000000;
    }

    public double getGcContent() {
        return gcContent;
    }
}
