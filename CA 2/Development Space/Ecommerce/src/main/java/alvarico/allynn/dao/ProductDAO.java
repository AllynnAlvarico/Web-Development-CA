package alvarico.allynn.dao;

import alvarico.allynn.configuration.DatabaseConnection;
import alvarico.allynn.model.Product;

import java.sql.*;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DatabaseConnection dbConfig = new DatabaseConnection();
    private String schemaName;

    public ProductDAO(String schemaName) {
        this.schemaName = schemaName;
    }

    public void addProduct(Product p) {
        dbConfig.setSchema(this.schemaName);
        String sql = "INSERT INTO product_table (prod_name, prod_description) VALUES (?, ?)";
        try (Connection conn = dbConfig.getDesktopConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getName());
            pstmt.setString(2, p.getDescription());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Product> getAllProducts() {
        System.out.println(this.getClass().getName() + " Retrieving all products from schema " + this.schemaName);
        dbConfig.setSchema(this.schemaName);
        System.out.println("Executing SQL line");
        String sql = "SELECT * FROM product_table";
        List<Product> products = new ArrayList<>();
        try (Connection conn = dbConfig.getDesktopConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("prod_id"));
                p.setName(rs.getString("prod_name"));
                p.setDescription(rs.getString("prod_description"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                products.add(p);

//                System.out.println("product id: " + p.getId());
//                System.out.println("Loaded product: " + p.getName());
//                System.out.println("Product description: " + p.getDescription());
//                System.out.println("Product category: " + p.getCategory());
//                System.out.println("Product price: " + p.getPrice());
            }
            System.out.println("End of result set");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
