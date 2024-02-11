package com.Ecommerce.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Ecommerce.Entity.Token;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    // Updated query to correctly join Token with User entity
    @Query("SELECT t FROM Token t WHERE t.user.customerId = :customerId AND t.loggedOut = false")
    List<Token> findAllTokensByUser(Long customerId);

    Optional<Token> findByToken(String token);
}
