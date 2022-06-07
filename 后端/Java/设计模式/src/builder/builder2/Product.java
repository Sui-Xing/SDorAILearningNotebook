package builder.builder2;

public class Product {
    private String buildA="汉堡";
    private String buildB="薯条";
    private String buildC="可乐";
    private String buildD="鸡肉卷";

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
