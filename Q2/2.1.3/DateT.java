import java.util.Calendar;

public class DateT {
    // properties
    private int year;
    private int month;
    private int day;

    // constructors
    public DateT(int m, int d, int y) {
        setYear(y);
        setMonth(m);
        setDay(d);
    }
    public DateT(int m, int d) {
        Calendar now = Calendar.getInstance();
        setYear(now.get(Calendar.YEAR));
        setMonth(m);
        setDay(d);
    }
    public DateT() {
        Calendar now = Calendar.getInstance();
        setYear(now.get(Calendar.YEAR));
        setMonth(now.get(Calendar.MONTH) + 1);
        setDay(now.get(Calendar.DATE));
    }
    
    // getters
    public int getYear() {
        return this.year;
    }
    public int getMonth() {
        return this.month;
    }
    public int getDay() {
        return this.day;
    }

    // setters
    // todo add out of bound ranges
    public void setYear(int newYear) {
        this.year = newYear;
    }
    public void setMonth(int newMonth) {
        this.month = newMonth;
    }
    public void setDay(int newDay) {
        this.day = newDay;
    }

    // more
    public String toString() {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        return
            monthNames[this.month-1] +
            " " + this.day +
            ", " + this.year;
    }

    public boolean equals(DateT other) {
        return this.day == other.day && this.month == other.month && this.year == other.year; 
    }

    public int compareTo(DateT other) {
        if (this.equals(other)) return 0;
        // the actual numbers are irrelevant, as long as 6969*minYear > 500*maxMonth > 500*minMonth > 1*maxDay
        // 6969*1 > 500*12 > 500*1 > 1*365
        // 6969 > 6000, 500, 365
        return (6969 * (this.year - other.year)) + (500 * (this.month - other.month)) + (this.day - other.day);
    }

    public int ageAsOf(DateT other) {
        return (other.year - this.year) - ((other.month>=this.month && other.day>=this.day)? 0 : 1);
    }
}