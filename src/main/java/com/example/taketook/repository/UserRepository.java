package com.example.taketook.repository;

import com.example.taketook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findById(Integer id);
    public Optional<User> findBySurname(String username);
    public Optional<User> findByEmail(String email);
    public Optional<User> findByPhone(String phone);
    public List<User> findByAddress(String address);
    public Boolean existsByEmail(String email);
    public boolean existsById(Integer id);
    public boolean existsByPhone(String phone);
}
