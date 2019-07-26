/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

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
    private TableView<Part> partsTableview;

    @FXML
    private TableColumn<Part, Integer> partsTablePartIdCol;

    @FXML
    private TableColumn<Part, String> partsTablePartNameCol;

    @FXML
    private TableColumn<Part, Integer> partsTableInventoryLevelCol;

    @FXML
    private TableColumn<Part, Integer> partsTablePricePerUnitCol;

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
    private TableView<Product> productsTableview;

    @FXML
    private TableColumn<Product, Integer> ProductsTablePartIdCol;

    @FXML
    private TableColumn<Product, String> ProductsTablePartNameCol;

    @FXML
    private TableColumn<Product, Integer> ProductsTableInventoryLevelCol;

    @FXML
    private TableColumn<Product, Double> ProductsTablePricePerUnitCol;

    @FXML
    private Button addProductsButton;

    @FXML
    private Button exitProgramButton;

    @FXML
    void onActionAddPart(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
        
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
        if(partsTableview.getSelectionModel().getSelectedItem() != null)
        {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Delete Part?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                Inventory.deletePart(partsTableview.getSelectionModel().getSelectedItem());
                partsTableview.setItems(model.Inventory.getAllParts());
            } 
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select a part to delete.");
            alert.showAndWait();
        }
    }

    @FXML
    void onActionDeleteProduct(ActionEvent event) {

    }

    @FXML
    void onActionExit(ActionEvent event) {

        System.exit(0);
    }

    @FXML
    void onActionModifyPart(ActionEvent event) throws IOException {
        
        if (partsTableview.getSelectionModel().getSelectedItem() != null)
        {
        Stage stage; 
        Parent root;       
        stage=(Stage) modifyPartsButton.getScene().getWindow();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/ModifyPart.fxml"));
        root =loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        ModifyPartController MPController = loader.getController();
        MPController.recievePart(partsTableview.getSelectionModel().getSelectedItem());
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please select a part to modify.");
            alert.showAndWait();
        }
    }

    @FXML
    void onActionModifyProduct(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/ModifyProduct.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();        
        
    }

    @FXML
    void onActionSearchPart(ActionEvent event) {
        partsTableview.setItems(model.Inventory.lookupPart(partsSearchTxt.getText()));
    }

    @FXML
    void onActionSearchProduct(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        partsTableview.setItems(model.Inventory.getAllParts());
        
        productsTableview.setItems(model.Inventory.getallProducts());
        
        partsTablePartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        partsTablePartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        partsTableInventoryLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        
        partsTablePricePerUnitCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        ProductsTablePartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        ProductsTablePartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        ProductsTableInventoryLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        
        ProductsTablePricePerUnitCol.setCellValueFactory(new PropertyValueFactory<>("price"));
       
        }    
    
}
