package uz.ankeloff.House_Selling.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.ankeloff.House_Selling.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
}
