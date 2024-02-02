package co.com.pruebaFlypass.repository;

import co.com.pruebaFlypass.model.Client;
import co.com.pruebaFlypass.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>  {


    List<Product> findByClient(Long id);

}