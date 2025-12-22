public class Main {
    public static void main(String[] args) {
        Charity charity1 = new Charity("LiveStrong","Fighting with cancer");
        Charity charity2 = new Charity("Make-A-Wish", "Helping children");

        Donation donation1 = new Donation("ronaldo@gmail.com", 1000);
        Donation donation2 = new Donation("ronaldo@gmail.com", 2000);

        Donor donor = new Donor("Ronaldo",38);

        System.out.println(charity1);
        System.out.println(charity2);
        System.out.println(donation1);
        System.out.println(donation2);
        System.out.println(donor);

        if (donation1.getAmountmoney() > donation2.getAmountmoney()) {
            System.out.println("Ronaldo donated more money to LiveStrong");
        }
        else  if (donation1.getAmountmoney() < donation2.getAmountmoney()) {
            System.out.println("Ronaldo donated more money to Make-A-Wish");
        }
        else if(donation1.getAmountmoney() == donation2.getAmountmoney()){
            System.out.println("Ronaldo is a good person");
        }
    }
}