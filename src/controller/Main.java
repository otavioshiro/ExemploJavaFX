package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Veiculo;
import model.sqlite.VeiculoSQLite;

import java.util.ArrayList;

public class Main extends Application {

    private static Stage stage;

    private static Scene mainScene;
    private static Scene detailsScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Veiculo v = new Veiculo("fiat","uno",60);

        VeiculoSQLite database = new VeiculoSQLite();

        //database.create(v);

        database.update(new Veiculo(1,"VW","Brasilia",60));

        System.out.println(database.find(1));

        //System.out.println(database.all());

        System.exit(0);

        stage = primaryStage;

        primaryStage.setTitle("Exemplo FX");

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("../view/main_screen.fxml"));
        mainScene = new Scene(fxmlMain, 640, 400);

        Parent fxmlDetails = FXMLLoader.load(getClass().getResource("../view/details_screen.fxml"));
        detailsScene = new Scene(fxmlDetails, 640, 400);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void changeScreen(String src, Object userData){
        switch (src){
            case "main":
                stage.setScene(mainScene);
                notifyAllListeners("main", userData);
                break;
            case "details":
                stage.setScene(detailsScene);
                notifyAllListeners("details", userData);
                break;
        }
    }

    public static void changeScreen(String src){
        changeScreen(src,null);
    }

    public static void main(String[] args) {
        launch(args);
    }

    //------------------------------------------------------------------------------------------------------------------

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen{
        void onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l : listeners)
            l.onScreenChanged(newScreen, userData);
    }
}
