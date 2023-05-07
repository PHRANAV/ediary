package com.example.diary.repository;

import com.example.diary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
