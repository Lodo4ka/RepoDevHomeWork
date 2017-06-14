package controller;

import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.OrderInfoService;
import service.ProductService;
import utils.Context;

import java.io.IOException;
import java.util.List;

/**
 * Created by lodo4ka on 07/06/2017.
 */
public class ProductTableController {

    @FXML
    private TableView<Product> productTable;

    @FXML
   private Spinner<Integer> spin;



    ProductService productService = new ProductService();
    OrderInfoService orderInfoService = new OrderInfoService();


    public void initialize() {
        TableColumn nameColumn = createColumn("Name", "name");
        TableColumn descColumn = createColumn("Description", "description");
        TableColumn typeColumn = createColumn("Type", "type");
        TableColumn priceColumn = createColumn("Price", "price");

        ObservableList columns = productTable.getColumns();
        columns.addAll(nameColumn, descColumn, typeColumn, priceColumn);


        List<Product> allProducts = productService.getAll();

        ObservableList<Product> productList = FXCollections.observableArrayList(allProducts);
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


        orderInfoService.addOrder(selectedItem, Context.getUser(), spin.getValue());



        try {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/view/orderInfo.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void remove(ActionEvent actionEvent) {

        Product selectedItem = productTable.getSelectionModel().getSelectedItem();
        ObservableList<Product> items = productTable.getItems();
        items.remove(selectedItem);
    }
}
