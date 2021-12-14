package p38g4shopms.shopms.respositories;

import p38g4shopms.shopms.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
//import p38g4shopms.shopms.models.Store;
/*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*/

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String>{
    List<Product> findBynamestoreproduct(String namestoreproduct);
    List<Product> findByuserId(Integer userId);

}
