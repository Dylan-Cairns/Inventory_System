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
    
    private static ObservableList<Part> partsSearchResults = FXCollections.observableArrayList();
    
    private static ObservableList<Part> productsSearchResults = FXCollections.observableArrayList();
    
    public static void addPart(Part part)
    {
        allParts.add(part);
    }
    
    public static void addProduct(Product product)
    {
        allProducts.add(product);
    }
    
    public Part lookupPart(int id)
    {
        for(Part part : getAllParts())
        {
            if(part.getId() == id)
                return part;
        }
        return null;
    }
    
    public static ObservableList<Part> lookupPart(String partName) // FIXME add a if else statement to return the allproducts list if search is empty
    {
        if(partName == "")
        {
            return getAllParts();
        }
        if(!(partsSearchResults.isEmpty())); // if list is not empty, make it empty
                {
                    partsSearchResults.clear();
                }
        for(Part part : getAllParts())
        {
            if(part.getName().contains(partName))
            {
                partsSearchResults.add(part);
            }
        }
        return partsSearchResults;
    }
    
    public Product lookupProduct(int id)
    {
        for(Product product : getallProducts())
        {
            if(product.getId() == id)
                return product;
        }
        return null;
    }
    
    /*public boolean updatePart (int id, String partName)
    {
        int index = -1;
        
        for (Part part : getAllParts())
        {
            index++;
            
            if (part.getId() == id)
                    {
                        getAllParts().set
                        return true;
                    }
        }
        return false;
    } */

    public static void deletePart(Part selectedPart)
    {
        for(Part part : getAllParts())
        {
            if(part.getId() == selectedPart.getId())
                getAllParts().remove(part);
            System.out.println("deleted!");
        }
        System.out.println("not found.");
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

