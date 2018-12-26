package ru.unn.db.Library.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import ru.unn.db.Library.model.*;

import java.util.List;


public class ViewModel {
    private StringProperty searchArea = new SimpleStringProperty();

/*
    public String getSearchArea() {
        return searchArea.get();
    }

    public void setSearchArea(final String searchArea) {
        this.searchArea.set(searchArea);
    }
*/
    public StringProperty searchAreaProperty() {
        return searchArea;
    }
    private TableView table = new TableView();


    public ViewModel() {
        init();
    }

    public void showTable() {

        TableView<Book> table = new TableView<Book>();

        // Create column UserName (Data type of String).
        TableColumn<Book, String> bookNameCol //
                = new TableColumn<Book, String>("Название");

        // Create column Email (Data type of String).
        TableColumn<Book, String> authorCol//
                = new TableColumn<Book, String>("Автор");

        // Create column FullName (Data type of String).
        TableColumn<Book, String> genreCol//
                = new TableColumn<Book, String>("Жанр");

        // Create column FullName (Data type of String).
        TableColumn<Book, String> langCol//
                = new TableColumn<Book, String>("Язык");

        table.getColumns().addAll(bookNameCol, authorCol, genreCol, langCol);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);
/*
        stage.setTitle("TableView (o7planning.org)");

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);*/
        //  stage..show();
    }

    private void init() {
        searchArea.set("");

    }


    public void search(){
        BookDao bookDaoExmpl = new BookDao();
        List<Book> aaa = bookDaoExmpl.getAllBooks();
        System.out.println(aaa.get(0));
        System.out.println(searchArea);


    }

}
