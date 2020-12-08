import java.util.Calendar;

public class Date {
    // properties
    private int year;
    private int month;
    private int day;

    // constructors
    public Date(int m, int d, int y) {
        setYear(y);
        setMonth(m);
        setDay(d);
    }
    public Date(int m, int d) {
        Calendar now = Calendar.getInstance();
        setYear(now.get(Calendar.YEAR));
        setMonth(m);
        setDay(d);
    }
    public Date() {
        Calendar now = Calendar.getInstance();
        setYear(now.get(Calendar.YEAR));
        setMonth(now.get(Calendar.MONTH) + 1);
        setDay(now.get(Calendar.DATE));
    }
    
    // getters
    public int getYear() {
        return year;
    }
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    // setters
    // todo add out of bound ranges
    public void setYear(int newYear) {
        year = newYear;
    }
    public void setMonth(int newMonth) {
        month = newMonth;
    }
    public void setDay(int newDay) {
        day = newDay;
    }

    // testing
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}