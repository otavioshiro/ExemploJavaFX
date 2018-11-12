package controller;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

public class MainController {

    @FXML
    protected void btNovoAction(ActionEvent e){
        Main.changeScreen("details","dados para a tela detalhes");
    }

}
