package p38g4shopms.shopms.respositories;

import p38g4shopms.shopms.models.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface StoreRepository extends MongoRepository<Store, String>{
    List<Store> findByidcliente(Integer idcliente);
}
