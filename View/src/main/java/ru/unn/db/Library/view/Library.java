package ru.unn.db.Library.view;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import ru.unn.db.Library.viewmodel.ViewModel;
import ru.unn.db.Library.model.*;
import javafx.scene.control.cell.PropertyValueFactory;
/*
import ru.unn.agile.ConverterTemperatures.infrastructure.TxtLogger;
import ru.unn.agile.ConverterTemperatures.model.TemperaturesUnit;
import ru.unn.agile.ConverterTemperatures.viewmodel.ViewModel;
*/

public class Library {
    @FXML
    private ViewModel viewModel;

    @FXML
    private Button btnSearch;

    @FXML
    private TextField searchArea;

    private ObservableList <Book> booksData = FXCollections.observableArrayList();
    @FXML
    private TableView <Book> tableSearch;
    @FXML
    private TableColumn <Book, String> bookNameCol;
    @FXML
    private TableColumn <Book, String>  authorCol;
    @FXML
    private TableColumn <Book, String>  genreCol;
    @FXML
    private TableColumn <Book, String>  langCol;
    @FXML
    private TableColumn <Book, String>  statusCol;

    @FXML
    private ComboBox<SearchType> cbScale;

    @FXML
    void initialize() {

        searchArea.textProperty().bindBidirectional(viewModel.searchAreaProperty());
        cbScale.valueProperty().bindBidirectional(viewModel.searchProperty());

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                //viewModel.search();
                workTable();
            }
        });
    }


    private void searchingData() {
        booksData = viewModel.getSearchingList();
       // booksData.add(new Book("1", "Alex", "qwerty", "alex@mail.com", "fsehiu"));
    }

    public  void workTable(){
        // устанавливаем тип и значение которое должно хранится в колонке
        bookNameCol.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        genreCol.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        langCol.setCellValueFactory(new PropertyValueFactory<Book, String>("language"));
        statusCol.setCellValueFactory(new PropertyValueFactory<Book, String>("status"));

        searchingData();

        // заполняем таблицу данными
        tableSearch.setItems(booksData);
        }


}
