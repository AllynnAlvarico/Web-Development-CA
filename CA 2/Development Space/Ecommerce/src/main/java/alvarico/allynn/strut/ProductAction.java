package alvarico.allynn.strut;

import alvarico.allynn.model.Product;
import alvarico.allynn.service.ProductCreationService;
import alvarico.allynn.service.ProductRetrievalService;

import java.util.List;

public class ProductAction {

    private String name;
    private String description;

    private List<Product> products;

    private ProductCreationService creationService = new ProductCreationService();
    private ProductRetrievalService retrievalService = new ProductRetrievalService();
    public String list() {
        System.out.println("ProductAction.list() called");
        products = retrievalService.getAllProducts();
        System.out.println("ProductAction: loaded " + products.size() + " products");
        return "success";
    }

    public String create() {
        String result = creationService.createProduct(name, description);
        if ("SUCCESS".equals(result)) {
            System.out.println("ProductAction: product created OK: " + name);
            return "success";
        } else {
            System.out.println("ProductAction: Error creating product - " + result);
            return "error";
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
}
