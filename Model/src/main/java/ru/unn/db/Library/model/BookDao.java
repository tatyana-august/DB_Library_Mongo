package ru.unn.db.Library.model;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import ru.unn.db.Library.model.SearchType;


public class BookDao {

    //public List<Book> getBooks()

    Book book;



    private DBCollection bookCollection;
    private DBCollection authorCollection;
    private DBCollection genreCollection;

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

        authorCollection = db.getCollection("authors");
        if (authorCollection == null) {
            authorCollection = db.createCollection("authors", null);
        }

        genreCollection = db.getCollection("genres");
        if (genreCollection == null) {
            genreCollection = db.createCollection("genres", null);
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

    public ObservableList<Book> getAllBooks2() {
        List<Book> books = new ArrayList<Book>();

        DBCursor cursor = bookCollection.find();
        while (cursor.hasNext()) {
            DBObject dbo = cursor.next();
            books.add(Book.fromDBObject(dbo));
        }
        ObservableList<Book> observableList = FXCollections.observableList(books);

        return observableList;
    }

    public ObservableList getList( SearchType unit, String searchArea){
        switch (unit){
           case AUTHOR:
               return getListAuthor(searchArea);//8888
           case GENRE:
               return getListGenre(searchArea);//88
           case NAME:
           default:
               return getListName(searchArea);

        }
    }


    public ObservableList getListAuthor( String searchArea) {
        DBObject query = getQuery("name", searchArea);
        DBCursor cursor = authorCollection.find(query);
        ObservableList list = FXCollections.observableArrayList();

        while (cursor.hasNext()&&cursor.size()!=0) {
            DBObject dbo = cursor.next();

            String booksArray = dbo.get("books").toString();
            for (String retval : booksArray.split(" ")) {
           // for(int i=0; i<booksArray.length();i++){
                String str1 = retval.replaceAll("\\[", "").replaceAll(",", "").replaceAll("\\]", "");

                ObservableList list2 = FXCollections.observableArrayList();
                list2=getListNameForId(str1);

                for(int i=0; i<list2.size();i++){
                    list.add(list2.get(i));
                }
            }
        }
        return list;
    }
    public ObservableList getListGenre( String searchArea) {
        DBObject query = getQuery("name", searchArea);
        DBCursor cursor = genreCollection.find(query);
        ObservableList list = FXCollections.observableArrayList();

        while (cursor.hasNext()&&cursor.size()!=0) {
            DBObject dbo = cursor.next();

            String booksArray = dbo.get("books").toString();
            for (String retval : booksArray.split(" ")) {
                // for(int i=0; i<booksArray.length();i++){
                String str1 = retval.replaceAll("\\[", "").replaceAll(",", "").replaceAll("\\]", "");

                ObservableList list2 = FXCollections.observableArrayList();
                list2=getListNameForId(str1);

                for(int i=0; i<list2.size();i++){
                    list.add(list2.get(i));
                }
            }
        }
        return list;
    }
    public ObservableList getListNameForId( String _searchArea) {
        DBObject query = getQuery("id", _searchArea);
        DBCursor cursor = bookCollection.find(query);
        ObservableList list = FXCollections.observableArrayList();

        while (cursor.hasNext()&&cursor.size()!=0) {
            DBObject dbo = cursor.next();
            changeAuthor(dbo);
            changeGenre(dbo);
            list.add(Book.fromDBObject(dbo));
        }
        return list;
    }
    public ObservableList getListName( String searchArea) {
        DBObject query = getQuery("name", searchArea);
        DBCursor cursor = bookCollection.find(query);
        ObservableList list = FXCollections.observableArrayList();

        while (cursor.hasNext()&&cursor.size()!=0) {
            DBObject dbo = cursor.next();
            changeAuthor(dbo);
            changeGenre(dbo);
            list.add(Book.fromDBObject(dbo));
        }
        return list;
    }

    public void changeAuthor(DBObject dbo){
        String authorNumber = dbo.get("author").toString();
        DBObject query1 = getQuery("id", authorNumber);
        DBCursor cursor1 = authorCollection.find(query1);
        dbo.put("author", cursor1.next().get("name"));
    }

    public void changeGenre(DBObject dbo){
        String genreNumber = dbo.get("genre").toString();
        DBObject query2 = getQuery("id", genreNumber);
        DBCursor cursor2 = genreCollection.find(query2);
        dbo.put("genre", cursor2.next().get("name"));
    }

    private static DBObject getQuery(String where, String str) {
    BasicDBObjectBuilder whereBuilder = BasicDBObjectBuilder.start();

    // Use the append method (similar to the use of add method)
       whereBuilder.append(where, str);
    //
    DBObject dbo = whereBuilder.get();
       System.out.println("Where: " + dbo.toString());
       return dbo;
    }





  /*  public ObservableList<Book> getAllBooks2() {
        List<Book> books = new ArrayList<Book>();

        DBCursor cursor = bookCollection.find();
        while (cursor.hasNext()) {
            DBObject dbo = cursor.next();
            books.add(Book.fromDBObject(dbo));
        }
        ObservableList<Book> observableList = FXCollections.observableList(books);

        return observableList;
    }*/
}
