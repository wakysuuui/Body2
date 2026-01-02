import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Charity liveStrong = new Charity("LiveStrong", "Fighting with cancer");
        Charity makeAWish = new Charity("Make-A-Wish", "Helping children");

        Donor ronaldo = new Donor("Ronaldo", 41, "ronaldo@gmail.com");
        Donor messi = new Donor("Messi", 38, "messi@gmail.com");

        // Data pool
        List<Donation> donations = new ArrayList<>();
        donations.add(new MoneyDonation(ronaldo, liveStrong, LocalDate.of(2026, 1, 2), 1000));
        donations.add(new MoneyDonation(messi, makeAWish, LocalDate.of(2026, 1, 2), 2000));
        donations.add(new GoodsDonation(messi, liveStrong, LocalDate.of(2026, 1, 1), "Medicines", 700));

        // Print (toString)
        donations.forEach(System.out::println);

        // Filtering: donations for a specific charity
        List<Donation> forLiveStrong = donations.stream()
                .filter(d -> d.getCharity().getName().equalsIgnoreCase("LiveStrong"))
                .collect(Collectors.toList());

        System.out.println("\nFiltered (LiveStrong):");
        forLiveStrong.forEach(System.out::println);

        // Searching: find first donation by donor name
        Optional<Donation> firstFromMessi = donations.stream()
                .filter(d -> d.getDonor().getName().equalsIgnoreCase("Messi"))
                .findFirst();

        System.out.println("\nSearch (first donation from Messi):");
        System.out.println(firstFromMessi.orElse(null));

        // Sorting: by amount descending
        List<Donation> sortedByAmountDesc = donations.stream()
                .sorted(Comparator.comparingInt(Donation::getAmount).reversed())
                .collect(Collectors.toList());

        System.out.println("\nSorted (amount desc):");
        sortedByAmountDesc.forEach(System.out::println);

        // Example comparison (who donated more in money donations)
        int ronaldoMoney = donations.stream()
                .filter(d -> d instanceof MoneyDonation)
                .filter(d -> d.getDonor().equals(ronaldo))
                .mapToInt(Donation::getAmount)
                .sum();

        int messiMoney = donations.stream()
                .filter(d -> d instanceof MoneyDonation)
                .filter(d -> d.getDonor().equals(messi))
                .mapToInt(Donation::getAmount)
                .sum();

        if (ronaldoMoney > messiMoney) {
            System.out.println("\nRonaldo donated more money.");
        } else if (ronaldoMoney < messiMoney) {
            System.out.println("\nMessi donated more money.");
        } else {
            System.out.println("\nRonaldo == Messi (money donations).");
        }
    }
}
