public abstract class DateTest {
    public static void main(String[] args) {
        Date d1 = new Date(4, 20, 6969);
        System.out.println(d1);

        d1.setDay(10);
        System.out.println(d1);

        d1.setMonth(5);
        System.out.println(d1);

        d1.setYear(2020);
        System.out.println(d1);

        System.out.println(d1.getDay());
        System.out.println(d1.getMonth());
        System.out.println(d1.getYear());

        System.out.println(new Date(1, 23, 1997));
        System.out.println(new Date(5, 23));
        System.out.println(new Date());
    }
}
