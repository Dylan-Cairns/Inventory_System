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
import model.Part;

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
    
    public void recievePart(Part part)
    {
        idTxt.setText(String.valueOf(part.getId()));
        nameText.setText(part.getName());
        invText.setText(String.valueOf(part.getStock()));
        priceCostTxt.setText(String.valueOf(part.getPrice()));
        maxInvTxt.setText(String.valueOf(part.getMax()));
        minInvTxt.setText(String.valueOf(part.getMin()));
        
        if(part instanceof model.InHouse)
        {
            machineIDTxt.setText(String.valueOf(((model.InHouse) part).getMachineId()));
        }
        if(part instanceof model.Outsourced)
        {
            // FIXME add ability to set companyName; depends on displaying or greying out inhouse / outsourced relevant fields
        }
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
