package com.batch130.entity.concretes;

import com.batch130.entity.abstracts.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "image")
public class Image extends BaseEntity implements Serializable {

    private String imageName;

    private String imageType;

    private String description;

    private String path;

    @ManyToOne
    private Entry entry;


}
