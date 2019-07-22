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
    void onActionSavePart(ActionEvent event) throws IOException {
        int id = Integer.parseInt(idTxt.getText());
        String name = nameText.getText();
        double price = Double.parseDouble(priceCostTxt.getText());
        int stock = Integer.parseInt(invText.getText());
        int min = Integer.parseInt(minInvTxt.getText());
        int max = Integer.parseInt(maxInvTxt.getText());
        int machineId = Integer.parseInt(machineIDTxt.getText());
        String companyName = null; 
        
        if(inHouseRadioButton.isSelected())
        {
            Inventory.addPart(new InHouse(id, name, price, stock, min, max, machineId));
        }
        else
        {
            Inventory.addPart(new Outsourced(id, name, price, stock, min, max, companyName));
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