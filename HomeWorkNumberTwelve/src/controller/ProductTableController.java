package controller;

import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Created by lodo4ka on 07/06/2017.
 */
public class ProductTableController {


    @FXML
    private TableView<Product> productTable;

    private Scene fourthScene;


    public void initialize(){
        TableColumn nameColumn = createColumn("Name", "name");
        TableColumn descColumn = createColumn("Description", "description");
        TableColumn typeColumn = createColumn("Type", "type");
        TableColumn priceColumn = createColumn("Price", "price");

        ObservableList columns = productTable.getColumns();
        columns.addAll(nameColumn, descColumn, typeColumn, priceColumn);

        ObservableList<Product> productList = FXCollections.observableArrayList();
        productList.add(new Product("Nokia", "model Nokia 3310", "phone", "20$"));
        productList.add(new Product("Iphone", "model Iphone 7", "smartphone", "700$"));
        productList.add(new Product("Samsung", "model galaxy tab 3", "tab", "500$"));

        productTable.setItems(productList);


    }

    public TableColumn createColumn(final String nameColumn, String entityFieldName) {
        TableColumn column = new TableColumn(nameColumn);
        column.setMinWidth(100);
        column.setCellValueFactory(new PropertyValueFactory<>(entityFieldName));
        return column;
    }


    public void select(ActionEvent actionEvent) {

        Product selectedItem = productTable.getSelectionModel().getSelectedItem();
        System.out.println(selectedItem);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(fourthScene);
    }


    public void remove(ActionEvent actionEvent) {

        Product selectedItem = productTable.getSelectionModel().getSelectedItem();
        ObservableList<Product> items = productTable.getItems();
        items.remove(selectedItem);
    }

    public void setFourthScene(Scene fourthScene) {
        this.fourthScene = fourthScene;
    }
}
