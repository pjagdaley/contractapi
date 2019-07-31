package com.sundeus.user.repository;
import com.sundeus.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     User findByEmailAddress(String username);
}



