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
@Table(name = "user_status",
uniqueConstraints = {
    @UniqueConstraint(name ="unique_user_status_id", columnNames = "user_status_id"),
    @UniqueConstraint(name ="unique_user_status_description", columnNames = "description")
})
public class User_Status {

    @Id
    @SequenceGenerator(name = "user_status_sequence",sequenceName = "user_status_sequence",allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "user_status_sequence")
    @Column(name="usid",updatable = false)
    private int id;

    @Column(name = "user_status_id", nullable = false, updatable = false, columnDefinition = "TEXT")
    private String user_status_id;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "createdOn", nullable = false, updatable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant createdOn;

    @Column(name = "updateOn", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private Instant updateOn;

    @OneToMany(mappedBy = "user_status")
    private Set<User_Account> user_status;

    public User_Status(String user_status_id, String description, Instant createdOn, Instant updateOn) {
        this.user_status_id = user_status_id;
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
        return user_status_id;
    }

    public void setUserstatus_id(String usertype_id) {
        this.user_status_id = usertype_id;
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
