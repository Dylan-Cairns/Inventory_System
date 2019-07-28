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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import static model.Inventory.getAllParts;
import model.Outsourced;
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

            Alert alert = new Alert(AlertType.CONFIRMATION); // confirm before returning to main menu
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Forget changes and return to main menu?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }      
        
    }

    @FXML
    void onActionPartInHouse(ActionEvent event) {
        machineIDLabel.setText("Machine ID");
    }

    @FXML
    void onActionPartOutsourced(ActionEvent event) {
        machineIDLabel.setText("Company Name");
    }

    @FXML
    void onActionSavePart(ActionEvent event) throws IOException {
        try
        {
            int id = Integer.parseInt(idTxt.getText());
            String name = nameText.getText();
            double price = Double.parseDouble(priceCostTxt.getText());
            int stock = Integer.parseInt(invText.getText());
            int min = Integer.parseInt(minInvTxt.getText());
            int max = Integer.parseInt(maxInvTxt.getText());  
            InHouse tempInhousePart;
            Outsourced tempOutsourcedPart;
            
            if (min >= max) //check min is less than max inventory
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Maximum value must be greater than minimum");
                alert.showAndWait();
            }
            else if(stock < min || stock > max) // check entered stock level is between min and max
            {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setContentText("Stock value must be between Minimum and Maximum");
                alert.showAndWait();
            }
            else { // update part
                if(inHouseRadioButton.isSelected())
                {
                    int machineId = Integer.parseInt(machineIDTxt.getText());
                    tempInhousePart = new InHouse(id, name, price, stock, min, max, machineId);
                    
                    int index = -1;
                    for(Part part : getAllParts())
                    {
                        index++;
                        if(part.getId() == id)
                        getAllParts().set(index, tempInhousePart);
                    }
                }
                else
                {
                    String companyName = machineIDTxt.getText();
                    tempOutsourcedPart = new Outsourced(id, name, price, stock, min, max, companyName);
                    System.out.println(tempOutsourcedPart.getCompanyName());
                    int index = -1;
                    for(Part part : getAllParts())
                    {
                        index++;
                        if(part.getId() == id)
                        getAllParts().set(index, tempOutsourcedPart);
                    }
                }
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
            inHouseRadioButton.setSelected(true);
            machineIDLabel.setText("Machine ID");
        }
        else if(part instanceof model.Outsourced)
        {
            machineIDTxt.setText(String.valueOf(((model.Outsourced) part).getCompanyName()));
            outsourcedRadioButton.setSelected(true);
            machineIDLabel.setText("Company Name");
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
