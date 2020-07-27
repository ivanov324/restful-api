package com.orazgaliyev.astana.repo;

import com.orazgaliyev.astana.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByLogin(String userName);
    Optional<UserEntity> deleteByLogin(String userName);
}
