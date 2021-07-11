package io.dumerz.springjpadata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.dumerz.springjpadata.model.User_Account;

public interface UserAccountRepository extends JpaRepository<User_Account, Long> {

}
