import java.time.LocalDate;
import java.util.Objects;

public abstract class Donation {
    private Donor donor;
    private Charity charity;
    private LocalDate date;

    protected Donation(Donor donor, Charity charity, LocalDate date) {
        this.donor = donor;
        this.charity = charity;
        this.date = date;
    }

    public Donor getDonor() { return donor; }
    public Charity getCharity() { return charity; }
    public LocalDate getDate() { return date; }

    public void setDonor(Donor donor) { this.donor = donor; }
    public void setCharity(Charity charity) { this.charity = charity; }
    public void setDate(LocalDate date) { this.date = date; }

    public abstract int getAmount();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{donor=" + donor + ", charity=" + charity +
                ", date=" + date + ", amount=" + getAmount() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return Objects.equals(donor, donation.donor) &&
                Objects.equals(charity, donation.charity) &&
                Objects.equals(date, donation.date) &&
                getAmount() == donation.getAmount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(donor, charity, date, getAmount());
    }
}

class MoneyDonation extends Donation {
    private int amountMoney;

    public MoneyDonation(Donor donor, Charity charity, LocalDate date, int amountMoney) {
        super(donor, charity, date);
        this.amountMoney = amountMoney;
    }

    public int getAmountMoney() { return amountMoney; }
    public void setAmountMoney(int amountMoney) { this.amountMoney = amountMoney; }

    @Override
    public int getAmount() {
        return amountMoney;
    }
}

class GoodsDonation extends Donation {
    private String item;
    private int estimatedValue;

    public GoodsDonation(Donor donor, Charity charity, LocalDate date, String item, int estimatedValue) {
        super(donor, charity, date);
        this.item = item;
        this.estimatedValue = estimatedValue;
    }

    public String getItem() { return item; }
    public int getEstimatedValue() { return estimatedValue; }

    public void setItem(String item) { this.item = item; }
    public void setEstimatedValue(int estimatedValue) { this.estimatedValue = estimatedValue; }

    @Override
    public int getAmount() {
        return estimatedValue;
    }

    @Override
    public String toString() {
        return "GoodsDonation{donor=" + getDonor() + ", charity=" + getCharity() + ", date=" + getDate() +
                ", item='" + item + "', estimatedValue=" + estimatedValue + "}";
    }
}