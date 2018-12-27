package ru.unn.db.Library.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import ru.unn.db.Library.model.*;
import javafx.collections.ObservableList;

import java.util.List;


public class ViewModel {
    private StringProperty searchArea = new SimpleStringProperty();

    private final ObjectProperty<ObservableList<SearchType>> units =
            new SimpleObjectProperty<>(
                    FXCollections.observableArrayList(SearchType.values()));
    private final ObjectProperty<SearchType> unit =
            new SimpleObjectProperty<SearchType>();
    BookDao bookDaoExmpl = new BookDao();


    public String getSearchArea() {
        return searchArea.get();
    }

    public void setSearchArea(final String searchArea) {
        this.searchArea.set(searchArea);
    }

    public StringProperty searchAreaProperty() {
        return searchArea;
    }
    private TableView table = new TableView();


    public ViewModel() {
        init();

    }

    public ObjectProperty<SearchType> searchProperty() {
        return unit;
    }
    public ObjectProperty<ObservableList<SearchType>> unitsProperty() {
        return units;
    }

    public final ObservableList<SearchType> getUnits() {
        return units.get();
    }

    private void init() {
        searchArea.set("");
        unit.set(SearchType.NAME);

    }
    public SearchType getUnit() {
        return unit.get();
    }


    public ObservableList getSearchingList(){




        ObservableList<Book> list = bookDaoExmpl.getList( unit.getValue(), getSearchArea());//!


        return list;
    }



}
