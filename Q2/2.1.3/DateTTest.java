public abstract class DateTTest {
    public static void main(String[] args) {
        // basic constructor
        DateT d1 = new DateT(4, 20, 6969);
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
        System.out.println(new DateT(1, 23, 1997));
        System.out.println(new DateT(5, 23));
        System.out.println(new DateT());

        // equals
        System.out.println(new DateT(1, 23, 1997).equals(new DateT(1, 23, 1997)));
        System.out.println(new DateT(5, 23).equals(new DateT(5, 21)));

        // compareTo
        System.out.println(new DateT(12, 25, 2020).compareTo(new DateT(4, 13, 1946)));
        
        System.out.println(new DateT(12, 25, 2020).compareTo(new DateT(12, 25, 2021)));
        System.out.println(new DateT(11, 25, 2020).compareTo(new DateT(12, 25, 2020)));
        System.out.println(new DateT(12, 25, 2020).compareTo(new DateT(12, 26, 2020)));

        System.out.println(new DateT(12, 25, 2020).compareTo(new DateT(12, 25, 2020)));

        System.out.println(new DateT(12, 25, 2021).compareTo(new DateT(12, 25, 2020)));
        System.out.println(new DateT(12, 25, 2020).compareTo(new DateT(11, 25, 2020)));
        System.out.println(new DateT(12, 26, 2020).compareTo(new DateT(12, 25, 2020)));

        DateT birthdate = new DateT(3, 6, 1973);
        System.out.println(birthdate.ageAsOf(new DateT(2, 5, 1974))); // 0
        System.out.println(birthdate.ageAsOf(new DateT(12, 11, 2020))); // 47
        System.out.println(birthdate.ageAsOf(new DateT(3, 5, 2023))); // 49
        System.out.println(birthdate.ageAsOf(new DateT(3, 6, 2023))); // 50
    }
}
