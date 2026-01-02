import java.util.Objects;

public class Charity {
    private String name;
    private String purpose;

    public Charity(String name, String purpose) {
        this.name = name;
        this.purpose = purpose;
    }

    public String getName() { return name; }
    public String getPurpose() { return purpose; }

    public void setName(String name) { this.name = name; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    @Override
    public String toString() {
        return "Charity{name='" + name + "', purpose='" + purpose + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Charity)) return false;
        Charity charity = (Charity) o;
        return Objects.equals(name, charity.name) &&
                Objects.equals(purpose, charity.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, purpose);
    }
}
    