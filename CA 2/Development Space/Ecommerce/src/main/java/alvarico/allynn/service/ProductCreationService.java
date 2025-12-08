package alvarico.allynn.service;

// import alvarico.allynn.model.Product;

import alvarico.allynn.configuration.DatabaseConnection;
import alvarico.allynn.dao.ProductDAO;
import alvarico.allynn.model.Product;

public class ProductCreationService {

    private DatabaseConnection dbConfig = new DatabaseConnection();
    private Product product;
    private ProductDAO productDAO = new ProductDAO(dbConfig.getPcSchema());

    public String createProduct(String name, String description) {
        try {
            product = new Product();
            product.setName(name);
            product.setDescription(description);

            productDAO.addProduct(product);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    public String toString() {
        return """
                Product Creation Service: {
                    Product ID: %d,
                    Product Name: %s,
                    Product Description: %s
                }""".formatted(product.getId(), product.getName(), product.getDescription());
    }
}
