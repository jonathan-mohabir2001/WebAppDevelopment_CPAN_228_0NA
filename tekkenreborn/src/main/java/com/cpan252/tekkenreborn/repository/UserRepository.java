package com.cpan252.tekkenreborn.repository;

import com.cpan252.tekkenreborn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
