public class isValidDate {
    public static void main(String[] args) {
        // test isLeapYear
        System.out.println("\n\n\nTesting isLeapYear:\n");
        
        int[] leapYearTestCases = {
            0, 3, 4, 1600, 1700,
            1800, 1900, 1934, 1936,
            1999, 2000, 2003, 2004,
            2005, 2006, 2007, 2008,
            2009, 2010, 2020
        };
        
        for (int year : leapYearTestCases) {
            System.out.println("isLeapYear(" + year + "): " + isLeapYear(year));
        }
        
        // test isValidDate
        System.out.println("\n\n\nTesting isValidDate:\n");
        
        int[][] validDateTestCases = {
            // {month, day, year}, // expected result
            {3, 6, 1973}, // true
            {4, 31, 2010}, // false – April has 30 days
            {13, 2, 1993}, // false – No 13th month
            {5, 13, -203}, // false – No negative years
            {2, 29, 2020}, // true
            {2, 29, 2021}, // false
            {2, 29, 2100}, // false
            {2, 29, 2400} // true
        };
        
        for (int[] date : validDateTestCases) {
            // I REALLY don't like strings in java.
            // it would be nice if we could do something like `isValidDate(${date[0]}, ${date[1]}, ${date[2]}): ${result}`
            System.out.println(
                "isValidDate(" + date[0] + ", " + date[1] + ", " + date[2] + "): " +
                isValidDate(date[0], date[1], date[2])
            );
        }
    }
    
    
    
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }
    
    public static boolean isValidDate(int month, int day, int year) {
        int[] daysInAMonth = {
            31, // jan
                                         // The upper bound for a day in February is different in a leap year.
            (isLeapYear(year)? 29 : 28), // feb! We use the spicy hot ternary operator! Very cool.
            31, // mar
            30, // apr
            31, // may
            30, // jun
            31, // jul
            31, // aug
            30, // sep
            31, // oct
            30, // nov
            31  // dec!!!
        };
        
        // The month must be in the range from 1 to 12.
        if (!(month>=1 && month<=12)) return false;
        
        // The day must be at least 1, but the upper bound on the day range depends on the month.
        if (!(day>=1 && day<=daysInAMonth[month-1])) return false;
        
        // The year must be a positive number (no B.C.E. here)
        if (!(year>=1)) return false;
        
        // if all the conditions are met, then our date is a spaghettig-ood to go
        return true;
    }
}