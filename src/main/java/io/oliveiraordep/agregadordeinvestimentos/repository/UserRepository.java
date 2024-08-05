package io.oliveiraordep.agregadordeinvestimentos.repository;

import io.oliveiraordep.agregadordeinvestimentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
