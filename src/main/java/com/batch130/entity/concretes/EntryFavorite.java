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
@Table(name = "entry_favorite")
public class EntryFavorite extends BaseEntity implements Serializable {

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private Entry entry;



}
