package ru.unn.db.Library.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ru.unn.db.Library.viewmodel.ViewModel;
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

    @FXML
    private TableView tableSearch;

    @FXML
    void initialize() {

        searchArea.textProperty().bindBidirectional(viewModel.searchAreaProperty());
        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.search();


            }
        });

    }



}
