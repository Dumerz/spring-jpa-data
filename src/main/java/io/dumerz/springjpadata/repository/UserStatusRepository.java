package io.dumerz.springjpadata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.dumerz.springjpadata.model.User_Status;

public interface UserStatusRepository extends JpaRepository<User_Status, Long> {
}
