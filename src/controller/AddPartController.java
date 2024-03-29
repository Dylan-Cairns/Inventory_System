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
import model.Outsourced;

/**
 * FXML Controller class
 *
 * @author Dylan
 */
public class AddPartController implements Initializable {

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
            else { // add new part
                if(inHouseRadioButton.isSelected())
                {
                    int machineId = Integer.parseInt(machineIDTxt.getText());
                    Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));
                }
                else
                {
                    String companyName = machineIDTxt.getText();
                    Inventory.addPart(new Outsourced(id, name, price, stock, min, max, companyName));
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // automatically set ID 
        int largestIdValue = -1;
        for(model.Part part : model.Inventory.getAllParts())
        {
            if(part.getId() > largestIdValue)
                largestIdValue = part.getId();
        }
        idTxt.setText(String.valueOf(largestIdValue + 1));
    }    
    
}