/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Dylan
 */
public class MainMenuController implements Initializable {
    
    Stage stage;
    Parent scene;
    
    @FXML
    private Button partsSearchButton;

    @FXML
    private TextField partsSearchTxt;

    @FXML
    private TableView<?> partsTableview;

    @FXML
    private TableColumn<?, ?> partsTablePartIdCol;

    @FXML
    private TableColumn<?, ?> partsTablePartNameCol;

    @FXML
    private TableColumn<?, ?> partsTableInventoryLevelCol;

    @FXML
    private TableColumn<?, ?> partsTablePricePerUnitCol;

    @FXML
    private Button addPartsButton;

    @FXML
    private Button modifyPartsButton;

    @FXML
    private Button deletePartsButton;

    @FXML
    private Button productsSearchButton;

    @FXML
    private TextField productsSearchTxt;

    @FXML
    private TableColumn<?, ?> ProductsTablePartIdCol;

    @FXML
    private TableColumn<?, ?> ProductsTablePartNameCol;

    @FXML
    private TableColumn<?, ?> ProductsTableInventoryLevelCol;

    @FXML
    private TableColumn<?, ?> ProductsTablePricePerUnitCol;

    @FXML
    private Button addProductsButton;

    @FXML
    private Button exitProgramButton;

    @FXML
    void onActionAddPart(ActionEvent event) {

    }

    @FXML
    void onActionAddProduct(ActionEvent event) throws IOException {
        
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionDeletePart(ActionEvent event) {

    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {

    }

    @FXML
    void onActionExit(ActionEvent event) {

    }

    @FXML
    void onActionModifyPart(ActionEvent event) {

    }

    @FXML
    void onActionModifyProduct(ActionEvent event) {

    }

    @FXML
    void onActionSearchPart(ActionEvent event) {

    }

    @FXML
    void onActionSearchProduct(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
