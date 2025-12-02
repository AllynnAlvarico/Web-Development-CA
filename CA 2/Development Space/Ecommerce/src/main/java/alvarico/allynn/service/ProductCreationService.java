package alvarico.allynn.service;

// import alvarico.allynn.model.Product;

public class ProductCreationService {
    private String product;

    public String createProduct(String prodName){
        setPName(prodName);
        return "Product created";
    }
    public void setPName(String prodName){
        this.product = prodName;
    }

    public String getProduct() {
        return this.product;
    }

//     private Product product;
//     public String createProduct(){
//         String productName = "Sample Product";
//         String productDescription = "This is a sample product description.";
//         double productPrice = 19.99;

//         this.product = new Product(productName, productDescription, productPrice);

//         return "Product created";
//     }

//     public Product createAnotherProduct(String name, String description, double price){
//         this.product = new Product(name, description, price);
//         return this.product;
//     }

//     public Product getProduct() {
//         return this.product;
//     }
}
