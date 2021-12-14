package p38g4shopms.shopms.models;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    private String codeproduct;
    private String namestoreproduct;
    private String productname;
    private Integer precio;
    private String categoria;
    private Integer userId;;


    public Product(String codeproduct, String namestoreproduct, String productname, Integer precio, String categoria, Integer userId) {
        this.codeproduct = codeproduct;
        this.namestoreproduct = namestoreproduct;
        this.productname = productname;
        this.precio = precio;
        this.categoria = categoria;
        this.userId = userId;

    }
    /*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*/

    public String getCodeproduct() {
        return codeproduct;
    }

    public void setCodeproduct(String codeproduct) {
        this.codeproduct = codeproduct;
    }

    public String getNamestoreproduct() {
        return namestoreproduct;
    }

    public void setNamestoreproduct(String namestoreproduct) {
        this.namestoreproduct = namestoreproduct;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
