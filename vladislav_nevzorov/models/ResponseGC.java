package my.rosalind.models;

public class ResponseGC {
    private String id;
    private double gc;

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
