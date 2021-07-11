package io.dumerz.springjpadata.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.Instant;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_type",
uniqueConstraints = {
    @UniqueConstraint(name ="unique_user_type_id", columnNames = "usertype_id"),
    @UniqueConstraint(name ="unique_user_type_description", columnNames = "description")
})
public class User_Type {

    @Id
    @SequenceGenerator(name = "user_type_sequence",sequenceName = "user_type_sequence",allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "user_type_sequence")
    @Column(name="utid",updatable = false)
    private int id;

    @Column(name = "usertype_id", nullable = false, updatable = false, columnDefinition = "TEXT")
    private String usertype_id;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "createdOn", nullable = false, updatable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant createdOn;

    @Column(name = "updateOn", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant updateOn;

    @OneToMany(mappedBy = "user_type")
    private Set<User_Account> user_accounts;

    public User_Type(String usertype_id, String description, Instant createdOn, Instant updateOn) {
        this.usertype_id = usertype_id;
        this.description = description;
        this.createdOn = createdOn;
        this.updateOn = updateOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsertype_id() {
        return usertype_id;
    }

    public void setUsertype_id(String usertype_id) {
        this.usertype_id = usertype_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Instant updateOn) {
        this.updateOn = updateOn;
    }
}
