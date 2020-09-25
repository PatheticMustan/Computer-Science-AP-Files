public class LeapYear {
    public static void main(String[] args) {
        int[] testCases = {
            0, 3, 4, 1600, 1700,
            1800, 1900, 1934, 1936,
            1999, 2000, 2003, 2004,
            2005, 2006, 2007, 2008,
            2009, 2010, 2020
        };
        
        for (int year : testCases) {
            System.out.println("isLeapYear(" + year + "): " + isLeapYear(year));
        }
        
    }
    
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }
}