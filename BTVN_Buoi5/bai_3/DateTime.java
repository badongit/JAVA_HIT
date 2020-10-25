package bai_3;

import java.util.Scanner;

public class DateTime {
    private int day;
    private int month;
    private int year;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày : ");
        day = scanner.nextInt();
        System.out.print("Nhập tháng : ");
        month = scanner.nextInt();
        System.out.print("Nhập năm : ");
        year = scanner.nextInt();
    }
    public void output(){
        System.out.printf("%2d/%2d/%-6d",day, month, year);
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public DateTime(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DateTime() {
    }
}
