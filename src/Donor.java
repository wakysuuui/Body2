import java.util.Objects;

public class Donor extends Person {
    private String email;

    public Donor(String name, int age, String email) {
        super(name, age);
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Donor{name='" + getName() + "', age=" + getAge() + ", email='" + email + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Donor)) return false;
        if (!super.equals(o)) return false;
        Donor donor = (Donor) o;
        return Objects.equals(email, donor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email);
    }
}