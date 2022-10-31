package neu.util.customTypes;

import java.time.LocalDate;
import java.time.Period;

public class Date {
    private int month;
    private int day;
    private int year;
    
    public Date() {}
    
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public int calculateAgeInYears() {
        LocalDate birthDate = LocalDate.of(this.year, this.month, this.day);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    
    public String getFormattedDate() {
        String seperator = "-";
        return this.month + seperator + this.day + seperator + this.year;
    }
}
