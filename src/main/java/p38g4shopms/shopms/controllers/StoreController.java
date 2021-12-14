package p38g4shopms.shopms.controllers;

import p38g4shopms.shopms.exceptions.StoreNotFoundException;
import p38g4shopms.shopms.models.Store;
import p38g4shopms.shopms.respositories.StoreRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StoreController {
    private final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    @GetMapping("/store/{storename}")
    Store getStore(@PathVariable String storename){
        return storeRepository.findById(storename).orElseThrow(()-> new StoreNotFoundException("No se encontro la tienda"));
    }

    @GetMapping("/store/user/{idcliente}")
    List<Store> getStoreByClient(@PathVariable Integer idcliente){
        List<Store> storeb = storeRepository.findByidcliente(idcliente);
        return storeb;
    }

    @PostMapping("/stores")
    Store newStore(@RequestBody Store store){
        return storeRepository.save((store));
    }

    @DeleteMapping("/store/delete/{storename}")
    String deleteStore(@PathVariable String storename){
        Store store = storeRepository.findById(storename).orElse(null);
        if (store == null){
            throw new StoreNotFoundException("La tienda no existe");
        }

        storeRepository.deleteById(storename);
        return "tienda eliminada";
    }

    @PutMapping("/store/update")
    Store updateStore(@RequestBody Store storeUpd){
        Store store = storeRepository.findById(storeUpd.getName()).orElse(null);
        if (store == null){
            throw new StoreNotFoundException("la tienda no existe");
        }
        store.setName(storeUpd.getName());
        store.setDetail(storeUpd.getDetail());
        store.setAdress(storeUpd.getAdress());

        return storeRepository.save(store);
    }
}
