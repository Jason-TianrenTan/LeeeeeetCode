package Controller;


import Transactions.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Util.Demo.*;

public class MainViewController implements Initializable {

    @FXML
    private Label dateLabel;

    @FXML
    private Label transIDLabel;

    @FXML
    private Label productNameLabel;

    @FXML
    private Label sellerLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TableView<Transaction> transactionTable;

    @FXML
    private ListView<String> listview;

    @FXML
    private TableColumn<?, ?> txDateCol;

    @FXML
    private TableColumn<?, ?> sellerCol;

    @FXML
    private TableColumn<?, ?> desCol;

    @FXML
    private TableColumn<?, ?> productCol;

    @FXML
    private TableColumn<?, ?> txidCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    public void Init() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<Transaction> transactions = new ArrayList<>();
        for (int i = 0;i<4;i++) {
            Transaction t = new Transaction(transactionHash[i], productNames[i], dates[i], sellers[i], txDates[i], descriptions[i]);
            transactions.add(t);
        }
        ObservableList<Transaction> data = FXCollections.observableArrayList(transactions);
        txidCol.setCellValueFactory(new PropertyValueFactory<>("transID"));
        productCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("str_date"));
        sellerCol.setCellValueFactory(new PropertyValueFactory<>("sellerID"));
        txDateCol.setCellValueFactory(new PropertyValueFactory<>("txDate"));
        desCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        transactionTable.setItems(data);
    }

}
