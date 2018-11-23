package controller;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import model.Veiculo;

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

    @FXML
    protected void btNovoAction(ActionEvent e){
        Main.changeScreen("details"," dados para a tela detalhes");
    }

    private void updateList(){
        lvVeiculos.getItems().clear();
        for(Veiculo v : Veiculo.all()) {
            lvVeiculos.getItems().add(v);
        }
    }

}
