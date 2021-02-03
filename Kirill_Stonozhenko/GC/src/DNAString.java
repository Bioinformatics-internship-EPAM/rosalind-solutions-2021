public class DNAString {
    private String content;
    private String name;

    public DNAString(String content, String name) {
        this.content = content;
        this.name = name;
    }

    public DNAString() {}

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double evaluateGCContent() {
        long countG = content.chars().filter(ch -> ch == 'G').count();
        long countC = content.chars().filter(ch -> ch == 'C').count();
        return (double)(countC + countG) / content.length();
    }
}
