package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import model.Veiculo;

import java.util.Optional;

public class MainController {

    @FXML
    protected ListView<Veiculo> lvVeiculos;

    @FXML
    protected void initialize(){
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if(newScreen.equals("main")) {
                    updateList();
                    //System.out.println("updateList()");
                }
            }
        });

        updateList();
    }

    //botões de ação na FXML Main

    @FXML
    protected void btNovoAction(ActionEvent e){
        Main.changeScreen("details");
    }

    @FXML
    protected void btEditarAction(ActionEvent e){
        ObservableList<Veiculo> ol = lvVeiculos.getSelectionModel().getSelectedItems();

        if (!ol.isEmpty()) {
            Veiculo v = ol.get(0);

            Main.changeScreen("details", v);
        }
    }

    @FXML
    protected void btDeleteAction(ActionEvent e){
        ObservableList<Veiculo> ol = lvVeiculos.getSelectionModel().getSelectedItems();
        if (!ol.isEmpty()){
            Veiculo v = ol.get(0);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Realmente deseja excluir este Veículo?");
            alert.setContentText(v.toString());

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK)
                v.delete();
                updateList();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText("Nenhum veículo selecionado!");
            alert.setContentText("Selecione algum elemento da lista");
            alert.showAndWait();
        }
    }

    private void updateList(){
        lvVeiculos.getItems().clear();
        for(Veiculo v : Veiculo.all()) {
            lvVeiculos.getItems().add(v);
        }
    }

}
