package View;

import Chain.AgentManager;
import Chain.CreateSecretKey;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AgentView extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getClassLoader().getResource("agentview.fxml"));
            Parent root = fxmlLoader.load(getClass().getClassLoader().getResource("agentview.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("数据交易系统Demo");
        //  fxmlLoader.load();
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
