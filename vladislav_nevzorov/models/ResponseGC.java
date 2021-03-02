package my.rosalind.models;

public class ResponseGC {
    private final String id;
    private final double gc;

    public ResponseGC(String id, double gc) {
        this.id = id;
        this.gc = gc;
    }

    public String getId() {
        return id;
    }

    public double getGc() {
        return gc;
    }
}
