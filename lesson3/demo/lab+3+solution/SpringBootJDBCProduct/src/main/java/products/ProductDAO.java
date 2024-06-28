package products;


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
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        jdbcTemplate.update("DELETE from product",namedParameters);
        jdbcTemplate.update("DELETE from supplier",namedParameters);
    }

    public void save(Product product) {
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productnumber", product.getProductNumber());
        namedParameters.put("name", product.getName());
        namedParameters.put("price", product.getPrice());
        jdbcTemplate.update("INSERT INTO product VALUES ( :productnumber, :name, :price)",namedParameters);

        // save creditcard
        Map<String,Object> namedParameterscc = new HashMap<String,Object>();
        namedParameterscc.put("supplierid", product.getSupplier().getSupplierId());
        namedParameterscc.put("name", product.getSupplier().getName());
        namedParameterscc.put("phone", product.getSupplier().getPhone());
        namedParameterscc.put("productnumber", product.getProductNumber());
        jdbcTemplate.update("INSERT INTO supplier VALUES ( :supplierid, :name, :phone, :productnumber)",namedParameterscc);
    }



    public Product findProductByNumber(int productNumber){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", productNumber);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "
                        + "productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Product( rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")));

        Supplier supplier = getSupplierForProduct(product.getProductNumber());
        product.setSupplier(supplier);
        return product;

    }

    public List<Product> getAllProducts(){
        List<Product> products = jdbcTemplate.query("SELECT * FROM product",
                new HashMap<String, Product>(),
                (rs, rowNum) -> new Product( rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")));

        for (Product product: products){
            Supplier supplier = getSupplierForProduct(product.getProductNumber());
            product.setSupplier(supplier);
        }
        return products;
    }

    Supplier getSupplierForProduct(int productNumber){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productNumber", productNumber);
        Supplier supplier = jdbcTemplate.queryForObject("SELECT * FROM supplier WHERE "
                        + "productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Supplier( rs.getInt("supplierId"),
                        rs.getString("name"),
                        rs.getString("phone")));

        return supplier;
    }

    public List<Product>  findByProductName(String productName){
        Map<String,Object> namedParameters = new HashMap<String,Object>();
        namedParameters.put("productName", productName);
        List<Product> products = jdbcTemplate.query("SELECT * FROM product WHERE "
                        + "name =:productName ",
                namedParameters,
                (rs, rowNum) -> new Product( rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")));

        for (Product product: products){
            Supplier supplier = getSupplierForProduct(product.getProductNumber());
            product.setSupplier(supplier);
        }
        return products;

    }

    public void removeProductByNumber(int productNumber) {
            Map<String,Object> namedParameters = new HashMap<String,Object>();
            namedParameters.put("productNumber", productNumber);
        jdbcTemplate.update("DELETE from product where productNumber = :productNumber",namedParameters);
        jdbcTemplate.update("DELETE from supplier where productNumber = :productNumber",namedParameters);
    }
}
