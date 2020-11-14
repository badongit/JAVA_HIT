package bai_3;

import java.util.Scanner;

public class News implements INews{
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;
    public float[] rateList = new float[3];
    @Override
    public void display() {
        System.out.printf("%-25s%-15s%-20s%-20s%-15f\n", title, publishDate, author, content, averageRate);
    }
    public void Calculate(){
        averageRate = (rateList[0] + rateList[1] + rateList[2])/3;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public News(int id, String title, String publishDate, String author, String content, float averageRate) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.content = content;
        this.averageRate = averageRate;
    }

    public News() {
    }
}
