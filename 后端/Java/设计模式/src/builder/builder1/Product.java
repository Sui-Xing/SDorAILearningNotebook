package builder.builder1;

public class Product {
    private String buildA;
    private String buildB;
    private String buildC;
    private String buildD;

    public void setBuildA(String buildA) {
        this.buildA = buildA;
    }

    public void setBuildB(String buildB) {
        this.buildB = buildB;
    }

    public void setBuildC(String buildC) {
        this.buildC = buildC;
    }

    public void setBuildD(String buildD) {
        this.buildD = buildD;
    }

    @Override
    public String toString() {
        return "Product{" +
                "buildA='" + buildA + '\'' +
                ", buildB='" + buildB + '\'' +
                ", buildC='" + buildC + '\'' +
                ", buildD='" + buildD + '\'' +
                '}';
    }
}
