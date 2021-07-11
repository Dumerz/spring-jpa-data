package io.dumerz.springjpadata.seeder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.dumerz.springjpadata.model.User_Account;
import io.dumerz.springjpadata.model.User_Status;
import io.dumerz.springjpadata.model.User_Type;
import io.dumerz.springjpadata.repository.UserAccountRepository;
import io.dumerz.springjpadata.repository.UserStatusRepository;
import io.dumerz.springjpadata.repository.UserTypeRepository;

@Component
public class DatabaseSeeder {

private UserTypeRepository userTypeRepository;
private UserStatusRepository userStatusRepository;
private UserAccountRepository userAccountRepository;

private static final List<User_Type> USERTYPES = Arrays.asList(
    new User_Type("USRTYPE001", "READER", Instant.now(), Instant.now()),
    new User_Type("USRTYPE002", "WRITER", Instant.now(), Instant.now()),
    new User_Type("USRTYPE003", "ADMINISTRATOR", Instant.now(), Instant.now()));

private static final List<User_Status> USERSTATUS = Arrays.asList(
    new User_Status("USRSTAT001", "NEW", Instant.now(), Instant.now()),
    new User_Status("USRSTAT002", "ACTIVE", Instant.now(), Instant.now()),
    new User_Status("USRSTAT003", "INACTIVE", Instant.now(), Instant.now()));

@Autowired
public DatabaseSeeder(UserTypeRepository userTypeRepository, UserStatusRepository userStatusRepository, UserAccountRepository userAccountRepository) {
    this.userTypeRepository = userTypeRepository;
    this.userStatusRepository = userStatusRepository;
    this.userAccountRepository = userAccountRepository;
}

@EventListener
public void seed(ContextRefreshedEvent event) {
    seedUserTypeTable();
    seedUserStatusTable();
    seedUserAccountTable();
}

private void seedUserStatusTable() {
    userTypeRepository.saveAll(USERTYPES);
}

private void seedUserTypeTable() {
    userStatusRepository.saveAll(USERSTATUS);
}


private void seedUserAccountTable() {
    Faker faker = new Faker();
    List<User_Account> user_accounts = new ArrayList<User_Account>();
    for(int i=1;i<=500;i++){  
        User_Account user_account = new User_Account(
            faker.name().username(),
            faker.crypto().sha256(),
            faker.internet().emailAddress(),
            faker.name().firstName(),
            faker.name().lastName(),
            faker.name().lastName(),
            USERTYPES.get(faker.number().numberBetween(0, 2)),
            USERSTATUS.get(faker.number().numberBetween(0, 2)),
            Instant.now(), Instant.now());
        user_accounts.add(user_account);
    }  
    userAccountRepository.saveAll(user_accounts);
}

}
