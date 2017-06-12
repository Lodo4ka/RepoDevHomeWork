package controller;

import entity.OrderInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.OrderInfoService;

import java.util.List;

/**
 * Created by lodo4ka on 08/06/2017.
 */
public class OrderInfoController {


    OrderInfoService orderInfoService = new OrderInfoService();

    @FXML
    TableView<OrderInfo> orderTable = new TableView<>();



    public void initialize(){

        TableColumn id = createColumn("Id", "id");
        TableColumn name = createColumn("Name", "name");
        TableColumn product = createColumn("Product", "product");
        TableColumn amount = createColumn("Amount", "amount");
        TableColumn price = createColumn("Price", "price");

        ObservableList columns = orderTable.getColumns();
        columns.addAll(id, name, product, amount, price);

        List<OrderInfo> infoList = orderInfoService.getInfo();
        ObservableList<OrderInfo> orderInfosList = FXCollections.observableArrayList(infoList);

        orderTable.setItems(orderInfosList);

    }

    private TableColumn createColumn(final String nameColumn, final String entityFieldName) {
        TableColumn column = new TableColumn();
        column.setMinWidth(100);
        column.setCellValueFactory(new PropertyValueFactory<>(entityFieldName));
        return column;
    }
}
