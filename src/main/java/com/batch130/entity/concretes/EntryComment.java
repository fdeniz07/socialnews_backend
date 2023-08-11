package com.batch130.entity.concretes;

import com.batch130.entity.abstracts.BaseEntity;
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
@Table(name = "entry_comment")
public class EntryComment extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String content;

//!!! sonra yorum satiri kaldirilacak
//    @ManyToOne
//    private Entry entry;

    @ManyToOne
    private User createdBy;

    //TODO: yorumunm yorumu nasil olacak
//    @OneToMany(mappedBy = "entry", cascade = CascadeType.REMOVE)
//    private List<EntryComment> entryComments;


    @OneToMany(mappedBy = "entryComment", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<EntryCommentVote> entryCommentVotes;

    @OneToMany(mappedBy = "entryComment", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<EntryCommentFavorite> entryCommentFavorites;




}
