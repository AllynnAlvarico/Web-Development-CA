package alvarico.allynn.service;

import alvarico.allynn.configuration.DatabaseConnection;
import alvarico.allynn.dao.ProductDAO;
import alvarico.allynn.model.Product;

import java.util.List;

public class ProductRetrievalService {
    private DatabaseConnection dbConfig = new DatabaseConnection();
    private ProductDAO productDAO = new ProductDAO(dbConfig.getPcSchema());

    public List<Product> getAllProducts() {
        System.out.println(this.getClass().getName() +  ": Retrieving all products from database");
        return productDAO.getAllProducts();
    }
}
