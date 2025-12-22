public class Charity {
    private String name;
    private String purpose;

    public Charity(String name, String purpose) {
        this.name = name;
        this.purpose = purpose;
    }
    public String getName() {
        return name;
    }
    public String getPurpose() {
        return purpose;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public String toString() {
        return "Charity{" + "name=" + name + ", purpose=" + purpose + '}';
    }
}