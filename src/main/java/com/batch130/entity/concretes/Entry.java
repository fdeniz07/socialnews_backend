package com.batch130.entity.concretes;

import com.batch130.entity.abstracts.BaseEntity;
import com.batch130.entity.enums.VoteType;
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
@Table(name = "entry")
public class Entry extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String content;

    private VoteType voteType;

    @ManyToOne
    private User createdBy;

    //!!! sonra yorum satiri kaldirilacak
//    // TODO: orphanRemoval ve cascade alanlari arasindaki fark endpointler yazilinca test edilecek!!!
//    @OneToMany(mappedBy = "entry",orphanRemoval = true ,cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) //FetchType: Eager olacak
//    private List<EntryComment> entryComments;
//
//    @OneToMany(mappedBy = "entry", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)//FetchType: Eager olacak
//    private List<EntryVote> entryVotes;
//
//    @OneToMany(mappedBy = "entry", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)//FetchType: Eager olacak
//    private List<EntryFavorite> entryFavorites;

    private Integer viewCount;

    private Integer commentCount;

    private String thumbnail;

    //!!! sonra yorum satiri kaldirilacak
//    @OneToMany(mappedBy = "entry", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)//FetchType: Eager olacak
//    private List<Image> image;

    private String seoAuthor;

    private String seoEntry;

    private String seoTags;

    //!!! sonra yorum satiri kaldirilacak
//    @ManyToOne()
//    private Category category;


}
