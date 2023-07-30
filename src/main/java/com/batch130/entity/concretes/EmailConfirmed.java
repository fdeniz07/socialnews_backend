package com.batch130.entity.concretes;

import com.batch130.entity.abstracts.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class EmailConfirmed extends BaseEntity implements Serializable {

    private String oldEmail;

    private String newEmail;


}
