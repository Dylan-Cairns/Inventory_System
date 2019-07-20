/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class ModifyProductController implements Initializable {

    @FXML
    private Label IdLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private Label invLbl;

    @FXML
    private TextField priceLbl;

    @FXML
    private Label maxLbl;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField invTxt;

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
    private TableView<?> addProductTableview;

    @FXML
    private TableColumn<?, ?> addPartTableviewPartIdCol;

    @FXML
    private TableColumn<?, ?> addPartTableviewPartNameCol;

    @FXML
    private TableColumn<?, ?> addPartTableviewInvLevelCol;

    @FXML
    private TableColumn<?, ?> addPartTableviewPricePerUnitCol;

    @FXML
    private Button addButton;

    @FXML
    private TableView<?> deleteProductTableview;

    @FXML
    private TableColumn<?, ?> deleteProductTableviewPartIdCol;

    @FXML
    private TableColumn<?, ?> deleteProductTableviewPartNameCol;

    @FXML
    private TableColumn<?, ?> deleteProductTableviewInventoryLevelCol;

    @FXML
    private TableColumn<?, ?> deleteProductTableviewPricePerUnitCol;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
