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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class ModifyPartController implements Initializable {
    
    Stage stage;
    Parent scene;
    
    @FXML
    private RadioButton inHouseRadioButton;

    @FXML
    private RadioButton outsourcedRadioButton;

    @FXML
    private Label idLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private Label invLbl;

    @FXML
    private Label priceCostLbl;

    @FXML
    private Label maxInvLbl;

    @FXML
    private Label machineIDLabel;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField nameText;

    @FXML
    private TextField invText;

    @FXML
    private TextField priceCostTxt;

    @FXML
    private TextField machineIDTxt;

    @FXML
    private TextField maxInvTxt;

    @FXML
    private Label minInvLbl;

    @FXML
    private TextField minInvTxt;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();        
        
    }

    @FXML
    void onActionPartInHouse(ActionEvent event) {

    }

    @FXML
    void onActionPartOutsourced(ActionEvent event) {

    }

    @FXML
    void onActionSavePart(ActionEvent event) {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
