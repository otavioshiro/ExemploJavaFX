package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Veiculo;

public class DetailsController {

    private Veiculo veiculoAtual;

    @FXML
    private TextField tfMarca;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfHP;


    @FXML
    protected void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("details"))

                    if (userData != null){
                         veiculoAtual = (Veiculo)userData;

                         tfMarca.setText(veiculoAtual.getMarca());
                         tfModelo.setText(veiculoAtual.getModelo());
                         tfHP.setText(String.valueOf(veiculoAtual.getHp()));

                    } else{
                        veiculoAtual = null;

                         tfMarca.setText("");
                         tfModelo.setText("");
                         tfHP.setText("");
                    }
                }
        });
    }

    @FXML
    protected void btCancelarAction(ActionEvent e) {
        Main.changeScreen("main");
    }

    @FXML
    protected void btOKAction(ActionEvent e) {

        try {

            if(tfMarca.getText().isEmpty())
                throw  new RuntimeException("O valor do atributo marca não pode estar vazio!");

            if (tfModelo.getText().isEmpty())
                throw new RuntimeException("O valor do atributo modelo não pode estar vazio!");

            if (veiculoAtual != null){
                veiculoAtual.setMarca(tfMarca.getText());
                veiculoAtual.setModelo(tfModelo.getText());
                veiculoAtual.setHp(Integer.parseInt(tfHP.getText()));

                veiculoAtual.save();
            } else {

                Veiculo v = new Veiculo(
                        tfMarca.getText(),
                        tfModelo.getText(),
                        Integer.parseInt(tfHP.getText()));

                v.save();
            }

            Main.changeScreen("main");

        } catch (NumberFormatException ex) {
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setTitle("");
            alert.setHeaderText("Erro ao criar Veículo");
            alert.setContentText("O atributo HP deve ser um valor numérico!");
            alert.showAndWait();
        } catch (RuntimeException ex){
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setTitle("");
            alert.setHeaderText("Erro ao criar Veículo");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }
}
