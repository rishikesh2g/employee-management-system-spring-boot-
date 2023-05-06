package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
//This is a Spring Boot repository interface that defines methods for performing 
//CRUD (Create, Read, Update, and Delete) operations on a database table that stores user data.