package com.batch130.entity.concretes;

import com.batch130.entity.abstracts.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@Table(name = "users")
public class User extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private boolean emailConfirmed;

    @OneToMany(mappedBy = "createdBy")
    @ToString.Exclude
    private List<Entry> entries;

    @OneToMany(mappedBy = "createdBy")
    @ToString.Exclude
    private List<EntryFavorite> entryFavorites;

    @OneToMany(mappedBy = "createdBy")
    @ToString.Exclude
    private List<EntryComment> entryComments;

    @OneToMany(mappedBy = "createdBy")
    @ToString.Exclude
    private List<EntryCommentFavorite> entryCommentsFavorites;

    @ManyToOne
    private Role role;

}
