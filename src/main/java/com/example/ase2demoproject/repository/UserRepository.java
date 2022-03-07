package com.example.ase2demoproject.repository;

import java.util.List;
import com.example.ase2demoproject.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
}
