package ru.unn.db.Library.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;


public class BookDao {

    //public List<Book> getBooks()

    Book book;



    private DBCollection bookCollection;

    public BookDao ()  {
        initDB();
    }

    @PostConstruct
    private void initDB()   {
        Mongo mongo = new Mongo();
        DB db = mongo.getDB("books");
        bookCollection = db.getCollection("books");
        if (bookCollection == null) {
            bookCollection = db.createCollection("books", null);
        }
    }

    public void createBook() {
        BasicDBObject doc = book.toDBObject();
        bookCollection.insert(doc);
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();

        DBCursor cursor = bookCollection.find();
        while (cursor.hasNext()) {
            DBObject dbo = cursor.next();
            books.add(Book.fromDBObject(dbo));
        }

        return books;
    }
}
