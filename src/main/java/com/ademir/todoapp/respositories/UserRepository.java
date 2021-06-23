package com.ademir.todoapp.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ademir.todoapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	 Optional<User> findUserByEmailAndPassword(String email, String password);
}
