package io.dumerz.springjpadata.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "user_account",
uniqueConstraints = {
    @UniqueConstraint(name ="unique_email", columnNames = "email"),
    @UniqueConstraint(name ="unique_username", columnNames = "username")
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

    @Column(name = "name_given", nullable = false, columnDefinition = "TEXT")
    private String name_given;

    @Column(name = "name_family", nullable = false, columnDefinition = "TEXT")
    private String name_family;

    @Column(name = "name_middle", nullable = true, columnDefinition = "TEXT")
    private String name_middle;

    @Column(name = "createdOn", nullable = false, updatable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant createdOn;

    @Column(name = "updateOn", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant updateOn;

    @ManyToOne
    @JoinColumn(name ="utid", nullable = false)
    private User_Type user_type;

    @ManyToOne
    @JoinColumn(name ="usid", nullable = false)
    private User_Status user_status;

    public User_Account(String username, String password, String email, String name_given, String name_family,
            String name_middle, User_Type user_type, User_Status user_status ,Instant createdOn, Instant updateOn) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name_given = name_given;
        this.name_family = name_family;
        this.name_middle = name_middle;
        this.user_type = user_type;
        this.user_status = user_status;
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

    public User_Type getUser_type() {
        return user_type;
    }

    public void setUser_type(User_Type user_type) {
        this.user_type = user_type;
    }

    public User_Status getUser_status() {
        return user_status;
    }

    public void setUser_status(User_Status user_status) {
        this.user_status = user_status;
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

    public String getName_given() {
        return name_given;
    }

    public void setName_given(String name_given) {
        this.name_given = name_given;
    }

    public String getName_family() {
        return name_family;
    }

    public void setName_family(String name_family) {
        this.name_family = name_family;
    }

    public String getName_middle() {
        return name_middle;
    }

    public void setName_middle(String name_middle) {
        this.name_middle = name_middle;
    }
}