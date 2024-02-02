package co.com.pruebaFlypass.repository;

import co.com.pruebaFlypass.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>  {

}