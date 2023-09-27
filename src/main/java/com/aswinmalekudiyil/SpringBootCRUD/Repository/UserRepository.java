package com.aswinmalekudiyil.SpringBootCRUD.Repository;

import com.aswinmalekudiyil.SpringBootCRUD.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
