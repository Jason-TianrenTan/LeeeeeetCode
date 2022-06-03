package Transactions;

import javafx.beans.property.SimpleStringProperty;

public class Transaction {

    private final SimpleStringProperty transID;
    private final SimpleStringProperty description, str_date, sellerID, productName, txDate;
    public Transaction(String transID, String productName, String date, String sellerID, String txDate, String des) {
        this.transID = new SimpleStringProperty(transID);
        this.productName = new SimpleStringProperty(productName);
        this.str_date = new SimpleStringProperty(date);
        this.sellerID = new SimpleStringProperty(sellerID);
        this.description = new SimpleStringProperty(des);
        this.txDate = new SimpleStringProperty(txDate);
    }

    public String getTransID() {
        return transID.get();
    }

    public SimpleStringProperty transIDProperty() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID.set(transID);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getStr_date() {
        return str_date.get();
    }

    public void setStr_date(String str_date) {
        this.str_date.set(str_date);
    }

    public String getSellerID() {
        return sellerID.get();
    }

    public void setSellerID(String sellerID) {
        this.sellerID.set(sellerID);
    }

    public String getProductName() {
        return productName.get();
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public String getTxDate() {
        return txDate.get();
    }


    public void setTxDate(String txDate) {
        this.txDate.set(txDate);
    }
}
