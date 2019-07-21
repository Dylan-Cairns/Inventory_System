/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Dylan
 */
public class Inventory {
    
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    
    public static void addPart(Part part)
    {
        allParts.add(part);
    }
    
    public static void addProduct(Product product)
    {
        allProducts.add(product);
    }
    
    public static ObservableList<Part> getAllParts()
    {
        return allParts;
    }
    
    public static ObservableList<Product> getallProducts()
    {
        return allProducts;
    }
}
