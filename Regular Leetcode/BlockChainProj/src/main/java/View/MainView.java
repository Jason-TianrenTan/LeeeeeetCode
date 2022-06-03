package View;

import Chain.Chain;
import Chain.CreateSecretKey;
import Controller.MainViewController;
import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.GUIState;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sun.applet.Main;
import Chain.AgentManager;

public class MainView extends Application {


    public void init() {
        CreateSecretKey secretKey = new CreateSecretKey();
        secretKey.printKeyStr();
    }

    public static void main(String[] args) {
        new MainView().init();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getClassLoader().getResource("mainview.fxml"));
            Parent root = fxmlLoader.load(getClass().getClassLoader().getResource("mainview.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("数据交易系统");
            fxmlLoader.load();
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
