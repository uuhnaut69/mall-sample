package com.uuhnaut69.mall.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uuhnaut69.mall.core.model.AbstractEntity;
import com.uuhnaut69.mall.domain.enums.RoleName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
@Data
@Entity
@Audited
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "User Model", description = "User's info")
public class User extends AbstractEntity {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    @Size(min = 3, max = 50)
    private String name;

    @Column(nullable = false, unique = true, updatable = false)
    @Size(min = 3, max = 50)
    private String username;

    @NaturalId
    @Size(max = 50)
    @Email
    @Column(nullable = false, unique = true, updatable = false)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    @Size(min = 6, max = 100)
    private String password;

    @Column(nullable = false)
    private boolean isEnabled = false;

    @Enumerated(EnumType.STRING)
    private RoleName role;

    private String avatar = "https://cdn.steemitimages.com/DQmbQGsqqhgTgZK2Wh4o3o9pALrNqPVryT3AH17J4WExoqS/no-image-available-grid.jpg";

    @JsonIgnore
    private String customerStripeId;

    @ManyToMany
    @JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_tag", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
