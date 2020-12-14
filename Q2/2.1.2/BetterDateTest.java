public abstract class BetterDateTest {
    public static void main(String[] args) {
        // basic constructor
        BetterDate d1 = new BetterDate(4, 20, 6969);
        System.out.println(d1);

        // setters
        d1.setDay(10);
        System.out.println(d1);

        d1.setMonth(5);
        System.out.println(d1);

        d1.setYear(2020);
        System.out.println(d1);

        // getters
        System.out.println(d1.getDay());
        System.out.println(d1.getMonth());
        System.out.println(d1.getYear());

        // toString + more constructors
        System.out.println(new BetterDate(1, 23, 1997));
        System.out.println(new BetterDate(5, 23));
        System.out.println(new BetterDate());

        // equals
        System.out.println(new BetterDate(1, 23, 1997).equals(new BetterDate(1, 23, 1997)));
        System.out.println(new BetterDate(5, 23).equals(new BetterDate(5, 21)));

        // compareTo
        System.out.println(new BetterDate(12, 25, 2020).compareTo(new BetterDate(4, 13, 1946)));
        
        System.out.println(new BetterDate(12, 25, 2020).compareTo(new BetterDate(12, 25, 2021)));
        System.out.println(new BetterDate(11, 25, 2020).compareTo(new BetterDate(12, 25, 2020)));
        System.out.println(new BetterDate(12, 25, 2020).compareTo(new BetterDate(12, 26, 2020)));

        System.out.println(new BetterDate(12, 25, 2020).compareTo(new BetterDate(12, 25, 2020)));

        System.out.println(new BetterDate(12, 25, 2021).compareTo(new BetterDate(12, 25, 2020)));
        System.out.println(new BetterDate(12, 25, 2020).compareTo(new BetterDate(11, 25, 2020)));
        System.out.println(new BetterDate(12, 26, 2020).compareTo(new BetterDate(12, 25, 2020)));
    }
}
