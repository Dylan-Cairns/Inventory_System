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
 * FXML Controller class
 *
 * @author Dylan
 */
public class AddProductController implements Initializable {
    
    Stage stage;
    Parent scene;

    @FXML
    private Label IdLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private Label invLbl;

    @FXML
    private Label priceLbl;

    @FXML
    private Label maxLbl;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField invTxt;

    @FXML
    private TextField priceTxt;

    @FXML
    private TextField maxTxt;

    @FXML
    private Label minLbl;

    @FXML
    private TextField minTxt;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTxt;

    @FXML
    private TableView<Part> addPartTableview;

    @FXML
    private TableColumn<Part, Integer> addPartTableviewPartIdCol;

    @FXML
    private TableColumn<Part, String> addPartTableviewPartNameCol;

    @FXML
    private TableColumn<Part, Integer> addPartTableviewInvLevelCol;

    @FXML
    private TableColumn<Part, Double> addPartTableviewPricePerUnitCol;

    @FXML
    private Button addButton;

    @FXML
    private TableView<Part> deletePartTableview;

    @FXML
    private TableColumn<Part, Integer> deletePartTableviewPartIdCol;

    @FXML
    private TableColumn<Part, String> deletePartTableviewPartNameCol;

    @FXML
    private TableColumn<Part, Integer> deletePartTableviewInventoryLevelCol;

    @FXML
    private TableColumn<Part, Double> deletePartTableviewPricePerUnitCol;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    void onActionAddPart(ActionEvent event) {
        (Inventory.lookupProduct(Integer.parseInt(idTxt.getText()))).addAssociatedPart(addPartTableview.getSelectionModel().getSelectedItem());
        deletePartTableview.setItems((Inventory.lookupProduct(Integer.parseInt(idTxt.getText()))).getAllAssociatedParts());
    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION); // confirm before returning to main menu
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Forget changes and return to main menu?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                Inventory.deleteProduct(Inventory.lookupProduct(Integer.parseInt(idTxt.getText())));
                stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }  
    }

    @FXML
    void onActionDeletePart(ActionEvent event) {
        (Inventory.lookupProduct(Integer.parseInt(idTxt.getText()))).deleteAssociatedPart(deletePartTableview.getSelectionModel().getSelectedItem());
        deletePartTableview.setItems((Inventory.lookupProduct(Integer.parseInt(idTxt.getText()))).getAllAssociatedParts());
    }

    @FXML
    void onActionSaveProduct(ActionEvent event) throws IOException {
        try
        {
            int id = Integer.parseInt(idTxt.getText());
            String name = nameTxt.getText();
            double price = Double.parseDouble(priceTxt.getText());
            int stock = Integer.parseInt(invTxt.getText());
            int min = Integer.parseInt(minTxt.getText());
            int max = Integer.parseInt(maxTxt.getText());
            double tempminPrice = 0.00;
            for(Part part : (Inventory.lookupProduct(Integer.parseInt(idTxt.getText()))).getAllAssociatedParts())
            {
                tempminPrice += part.getPrice();
            }

            if (min >= max) //check min is less than max inventory
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Maximum stock value must be greater than minimum");
                alert.showAndWait();
            }
            else if(stock < min || stock > max) // check entered stock level is between min and max
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Stock value must be between Minimum and Maximum");
                alert.showAndWait();
            }
            else if(price < tempminPrice) // check product price is greater than cost of parts
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Product price should be greater than total cost of associated parts. Total cost of associated parts is " + tempminPrice);
                alert.showAndWait();
            }
            else { // add new product
                Inventory.addProduct(new Product(id, name, price, stock, min, max));
                
                stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();    
                }
        }
        catch(NumberFormatException e)
        {           
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setContentText("Please enter valid values in all text fields.");
            alert.showAndWait();
        }

    }

    @FXML
    void onActionSearchPart(ActionEvent event) {
        addPartTableview.setItems(model.Inventory.lookupPart(searchTxt.getText()));
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        addPartTableview.setItems(model.Inventory.getAllParts());
        
        addPartTableviewPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        addPartTableviewPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        addPartTableviewInvLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        
        addPartTableviewPricePerUnitCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        deletePartTableviewPartIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        deletePartTableviewPartNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        deletePartTableviewInventoryLevelCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        
        deletePartTableviewPricePerUnitCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        // automatically set ID 
        int largestIdValue = -1;
        for(model.Product product : model.Inventory.getAllProducts())
        {
            if(product.getId() > largestIdValue)
                largestIdValue = product.getId();
        }
        idTxt.setText(String.valueOf(largestIdValue + 1));
        // create new product with generated ID
        Inventory.addProduct(new Product(largestIdValue + 1, "", 0.0, 0, 0, 0));
    }    
    
}
