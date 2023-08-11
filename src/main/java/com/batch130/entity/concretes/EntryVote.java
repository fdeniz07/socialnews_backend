package com.batch130.entity.concretes;

import com.batch130.entity.abstracts.BaseEntity;
import com.batch130.entity.enums.VoteType;
import jakarta.persistence.*;
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
@Table(name = "entry_vote")
public class EntryVote extends BaseEntity implements Serializable {

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.STRING)
    private VoteType voteType;

    //!!! sonra yorum satiri kaldirilacak
//    @ManyToOne
//    private Entry entry;



}
