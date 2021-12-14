package p38g4shopms.shopms.controllers;

import p38g4shopms.shopms.exceptions.ProductNotFoundException;
import p38g4shopms.shopms.models.Product;
import p38g4shopms.shopms.respositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    String checkMessage(){
        return "¡¡CONEXION EXITOSA3!!";
    }

    @GetMapping("/product/{codeproduct}")
    Product getProduct(@PathVariable String codeproduct){
        return productRepository.findById(codeproduct).orElseThrow(()-> new ProductNotFoundException("No se encontro el producto"));
    }

    @GetMapping("/product/user/{userId}")
    List<Product> getProduct(@PathVariable Integer userId){
      List<Product> prod = productRepository.findByuserId(userId);
      return prod;
    }

    @GetMapping("/product/store/{namestoreproduct}")
    List<Product> getProductByStore(@PathVariable String namestoreproduct){
        List<Product> product = productRepository.findBynamestoreproduct(namestoreproduct);
       return product;
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/product/delete/{codeproduct}")
    String deleteProduct(@PathVariable String codeproduct){
        Product product = productRepository.findById(codeproduct).orElse(null);
        if (product == null){
            throw new ProductNotFoundException("El producto no existe");
        }

        productRepository.deleteById(codeproduct);
        return "Producto eliminado";
    }

    @PutMapping("/product/update")
    Product updateProduct(@RequestBody Product productUpd){
        Product product = productRepository.findById(productUpd.getCodeproduct()).orElse(null);
        if (product == null){
            throw new ProductNotFoundException("El producto no existe");
        }
        product.setCodeproduct(productUpd.getProductname());
        product.setNamestoreproduct(productUpd.getNamestoreproduct());
        product.setProductname(productUpd.getProductname());
        product.setPrecio(productUpd.getPrecio());
        product.setCategoria(productUpd.getCategoria());

        return productRepository.save(product);
    }

}
