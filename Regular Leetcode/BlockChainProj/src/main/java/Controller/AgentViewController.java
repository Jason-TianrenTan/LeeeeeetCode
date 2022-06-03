package Controller;

import Chain.AgentManager;
import Transactions.Transaction;
import Util.Demo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Util.Demo.*;
import static Util.Demo.descriptions;

public class AgentViewController implements Initializable {

    AgentManager agentManager;
    ArrayList<Transaction> transactions = new ArrayList<>();
    boolean initialized = false;

    @FXML
    private Label desLabel4;

    @FXML
    private Label desLabel3;

    @FXML
    private Label desLabel2;

    @FXML
    private ImageView Img1;

    @FXML
    private Label nameLabel4;

    @FXML
    private ImageView Img2;

    @FXML
    private Label nameLabel3;

    @FXML
    private Button transBtn4;

    @FXML
    private Label nameLabel1;

    @FXML
    private Button transBtn2;

    @FXML
    private Button transBtn3;

    @FXML
    private ImageView Img3;

    @FXML
    private Button transBtn1;

    @FXML
    private ImageView Img4;

    @FXML
    private Label dateLabel1;

    @FXML
    private Label desLabel1;

    @FXML
    private Label dateLabel3;

    @FXML
    private Label nameLabel2;

    @FXML
    private Label dateLabel2;

    @FXML
    private Label dateLabel4;

    @FXML
    void onTransBtn1Clicked(ActionEvent event) {
        agentManager.performTransaction(transactions.get(0));
    }

    @FXML
    void onTransBtn2Clicked(ActionEvent event) {
        agentManager.performTransaction(transactions.get(1));
    }

    @FXML
    void onTransBtn3Clicked(ActionEvent event) {
        agentManager.performTransaction(transactions.get(2));
    }

    @FXML
    void onTransBtn4Clicked(ActionEvent event) {
        agentManager.performTransaction(transactions.get(4));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
        loadImages();
        loadData();
    }


    public void init() {
        agentManager = new AgentManager();
        agentManager.testInit();
        for (int i = 0; i < 4; i++) {
            Transaction t = new Transaction(transactionHash[i], productNames[i], dates[i], sellers[i], txDates[i], descriptions[i]);
            transactions.add(t);
        }

    }

    private void loadImages() {
        ImageView[] imageViews = {Img1, Img2, Img3, Img4};
        for (int i=0;i<4;i++) {
            Image image = new Image(getClass().getClassLoader().getResource("img/img" + (i + 1) + ".png").toExternalForm());
            imageViews[i].setImage(image);
        }
    }

    private void loadData() {
        Label[] nameLabels = {nameLabel1, nameLabel2, nameLabel3, nameLabel4};
        Label[] dateLabels = {dateLabel1, dateLabel2, dateLabel3, dateLabel4};
        Label[] desLabels = {desLabel1, desLabel2, desLabel3, desLabel4};
        for (int i=0;i<4;i++) {
            nameLabels[i].setText(productNames[i]);
            dateLabels[i].setText(dates[i]);
            desLabels[i].setText(descriptions[i]);
        }
    }
}
