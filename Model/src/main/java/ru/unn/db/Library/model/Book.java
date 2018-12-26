package ru.unn.db.Library.model;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Book {

    private String name;
    private String author;
    private String language;
    private String genre;

    //геттеры и сеттеры для полей

    public BasicDBObject toDBObject() {
        BasicDBObject document = new BasicDBObject();

        document.put("name", name);
        document.put("language", language);
        document.put("author", author);
        document.put("genre", genre);
        return document;
    }

    public static Book fromDBObject(DBObject document) {
        Book b = new Book();

        b.name = (String) document.get("name");
        b.language = (String) document.get("language");
        b.author = (String) document.get("author");
        b.author = (String) document.get("genre");

        return b;
    }
}