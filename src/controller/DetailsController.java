package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Veiculo;

public class DetailsController {

    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfHP;


    @FXML
    protected  void initialize(){
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if(newScreen.equals("details"))
                    System.out.println("nova tela "+newScreen+" ,"+userData);
            }
        });
    }

    @FXML
    protected void btCancelarAction(ActionEvent e){
        Main.changeScreen("main");
    }

    @FXML
    protected void btOKAction(ActionEvent e){

        Veiculo v = new Veiculo(
                tfMarca.getText(),
                tfModelo.getText(),
                Integer.parseInt(tfHP.getText()));

        v.save();

        Main.changeScreen("main");
    }
}
