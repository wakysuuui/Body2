public class Donation {
    private String email;
    private int amountmoney;

    public Donation(String email, int amountmoney) {
        this.email = email;
        this.amountmoney = amountmoney;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAmountmoney() {
        return amountmoney;
    }
    public void setAmountmoney(int amountmoney) {
        this.amountmoney = amountmoney;
    }
    public String toString() {
        return "Donation{" + "email=" + email + ", amountmoney=" + amountmoney + '}';
    }
}