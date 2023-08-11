package com.batch130.entity.concretes;

import com.batch130.entity.abstracts.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Table(name = "category")
public class Category extends BaseEntity {

    private String categoryName;

    private String categoryDetails;

//!!! sonra yorum satiri kaldirilacak
//    @OneToMany(mappedBy = "category", cascade = CascadeType.REFRESH)
//    private List<Entry> entries;

}
