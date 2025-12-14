package alvarico.allynn.model;

public class Product {

    private int id;
    private String name;
    private String description;
    private String category;
    private double price;

    public Product() {

    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public String getCategory() {
        return category;
    }
    public double getPrice() {
        return price;
    }
}
