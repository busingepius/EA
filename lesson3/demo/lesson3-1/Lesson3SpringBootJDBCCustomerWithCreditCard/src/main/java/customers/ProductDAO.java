package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class ProductDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void clearDB() {
        jdbcTemplate.getJdbcTemplate().execute("DELETE from product");
        jdbcTemplate.getJdbcTemplate().execute("DELETE from supplier");
    }

    public void save(Product product) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", product.getProductNumber());
        namedParameters.put("name", product.getName());
        namedParameters.put("price", product.getPrice());
        jdbcTemplate.update("INSERT INTO product VALUES ( :productNumber, :name, :price)",namedParameters);
    }

    //product.setSupplier(supplier);

    public Product getProduct(int productNumber){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", productNumber);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "
                        + "productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Product( rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                       ));
        return product;
    }

    public Supplier getSupplier(String name){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("name", name);
        Supplier supplier = jdbcTemplate.queryForObject("SELECT * FROM supplier WHERE "
                        + "name =:name ",
                namedParameters,
                (rs, rowNum) -> new Supplier( rs.getString("name"),
                        rs.getString("phone")
                       ));
        return supplier;
    }

    public List<Product> getAllProducts(){
        List<Product> products = jdbcTemplate.query("SELECT * FROM product",
                new HashMap<String, Product>(),
                (rs, rowNum) -> new Product( rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                       ));
        return products;
    }

    public List<Supplier> getAllSuppliers(){
        List<Supplier> suppliers = jdbcTemplate.query("SELECT * FROM supplier",
                new HashMap<String, Supplier>(),
                (rs, rowNum) -> new Supplier( rs.getString("name"),
                        rs.getString("phone")
                       ));
        return suppliers;
    }

    public void updateProduct(Product product) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", product.getProductNumber());
        namedParameters.put("name", product.getName());
        namedParameters.put("price", product.getPrice());
        jdbcTemplate.update("UPDATE product SET name = :name, price = :price WHERE productNumber = :productNumber",namedParameters);
    }

    public void updateSupplier(Supplier supplier) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("name", supplier.getName());
        namedParameters.put("phone", supplier.getPhone());
        jdbcTemplate.update("UPDATE supplier SET phone = :phone WHERE name = :name",namedParameters);
    }

    public void deleteProduct(int productNumber) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", productNumber);
        jdbcTemplate.update("DELETE FROM product WHERE productNumber = :productNumber",namedParameters);
    }

    public void deleteSupplier(String name) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("name", name);
        jdbcTemplate.update("DELETE FROM supplier WHERE name = :name",namedParameters);
    }

    public void deleteAllProducts() {
        jdbcTemplate.getJdbcTemplate().execute("DELETE from product");
    }

    public void deleteAllSuppliers() {
        jdbcTemplate.getJdbcTemplate().execute("DELETE from supplier");
    }

    public void save(Supplier supplier) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("name", supplier.getName());
        namedParameters.put("phone", supplier.getPhone());
        jdbcTemplate.update("INSERT INTO supplier VALUES ( :name, :phone)",namedParameters);
    }
}
