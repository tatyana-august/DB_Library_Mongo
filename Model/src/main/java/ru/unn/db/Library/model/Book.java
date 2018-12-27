package ru.unn.db.Library.model;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Book {

    private String name;
    private String author;
    private String language;
    private String genre;
    private String status;

    public Book(){
          name="";
          author="";
          language="";
          genre="";
          status="Library";
    }

    public Book(String name,String author,String language,String genre,String status){
        this.name = name;
        this.author = author;
        this.language = language;
        this.genre = genre;
        this.status = status;
    }
    //геттеры и сеттеры для полей
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public BasicDBObject toDBObject() {
        BasicDBObject document = new BasicDBObject();

        document.put("name", name);
        document.put("language", language);
        document.put("author", author);
        document.put("genre", genre);
        document.put("status", status);
        return document;
    }

    public static Book fromDBObject(DBObject document) {
        Book b = new Book();

        b.name = (String) document.get("name");
        b.language = (String) document.get("language");
        b.author = (String) document.get("author");
        b.genre = (String) document.get("genre");
        b.status = (String) document.get("status");

        return b;
    }
}