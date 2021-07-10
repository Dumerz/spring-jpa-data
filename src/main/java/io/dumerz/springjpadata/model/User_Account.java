package io.dumerz.springjpadata.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "User_Account",
uniqueConstraints = {
    @UniqueConstraint(name ="unique_email", columnNames = {"email"}),
    @UniqueConstraint(name ="unique_username", columnNames = {"username"})
})
public class User_Account {

    @Id
    @SequenceGenerator(name = "user_account_sequence",sequenceName = "user_account_sequence",allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "user_account_sequence")
    @Column(name="id",updatable = false)
    private Long id;

    @Column(name = "username", nullable = false, updatable = false, columnDefinition = "TEXT")
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name = "createdOn", nullable = false, updatable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant createdOn;

    @Column(name = "updateOn", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant updateOn;

    public User_Account(Long id, String username, String password, String email, Instant createdOn, Instant updateOn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdOn = createdOn;
        this.updateOn = updateOn;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }
    public Instant getUpdateOn() {
        return this.updateOn;
    }

    public void setUpdateOn(Instant updateOn) {
        this.updateOn = updateOn;
    }

    @Override
    public String toString() {
        return "User_Account [createdOn=" + createdOn + ", email=" + email + ", id=" + id + ", password=" + password
                + ", updateOn=" + updateOn + ", username=" + username + "]";
    }

}