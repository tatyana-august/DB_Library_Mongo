package ru.unn.db.Library.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;


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



    public ViewModel() {
        init();
    }

    private void init() {
        searchArea.set("");

    }


    public void search(){
    System.out.println(searchArea);
    }

}
