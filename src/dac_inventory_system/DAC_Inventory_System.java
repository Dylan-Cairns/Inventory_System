/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dac_inventory_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.InHouse;
import model.Inventory;
import model.Outsourced;
import model.Part;
import model.Product;

/**
 *
 * @author Dylan
 */
public class DAC_Inventory_System extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainMenu.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // add test data to inventory
        Inventory.addPart(new InHouse(1, "widget", 8.45, 33, 5, 50, 1));
        Inventory.addPart(new InHouse(2, "whatsit", 6.77, 45, 5, 50, 2));
        Inventory.addPart(new Outsourced(3, "cranker", 10.66, 20, 5, 25, "Crankers Inc"));
        Inventory.addPart(new Outsourced(4, "banger", 5.88, 10, 5, 60, "Bangers and co"));
        Inventory.addProduct(new Product(1, "Crankbanger 1000", 99.99, 59, 5, 60));
        Inventory.addProduct(new Product(2, "Donkey Prodder 8", 67.99, 45, 5, 50));
        Inventory.lookupProduct(1).addAssociatedPart(Inventory.lookupPart(1));
        Inventory.lookupProduct(1).addAssociatedPart(Inventory.lookupPart(2));
        Inventory.lookupProduct(2).addAssociatedPart(Inventory.lookupPart(3));
        Inventory.lookupProduct(2).addAssociatedPart(Inventory.lookupPart(4));
        
        launch(args);
    }
    
}
