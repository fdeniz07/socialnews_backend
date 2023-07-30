package com.batch130.entity.concretes;

import com.batch130.entity.abstracts.BaseEntity;
import com.batch130.entity.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Table(name = "role")
public class Role extends BaseEntity implements Serializable {

    private String roleName;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private String description;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REFRESH)
    private List<User> users;

}
