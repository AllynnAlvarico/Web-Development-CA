package alvarico.allynn.test;

import alvarico.allynn.service.ProductCreationService;
import alvarico.allynn.service.ProductRetrievalService;
import alvarico.allynn.strut.ProductAction;

public class ProductTest {
    ProductRetrievalService prs = new ProductRetrievalService();
    ProductCreationService pcs = new ProductCreationService();

    public void productRetrievalTest() {
        System.out.println("PRODUCT RETRIEVAL TEST");
        prs.getAllProducts().forEach(product -> {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("-------------------------");
        });
    }

    public void productAdditionTest() {
        System.out.println("PRODUCT ADDITION TEST");
        String result = pcs.createProduct("Model B", "Tesla");
        System.out.println("Product Addition Result: " + result);
    }
    public void runProductActionList() {
        System.out.println("PRODUCT ACTION LIST TEST");
        ProductAction pa = new ProductAction();
        pa.list();
        pa.getProducts().forEach(product -> {
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("-------------------------");
        });

    }

}
