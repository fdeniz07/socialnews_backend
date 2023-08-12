package com.batch130.payload.request;

import com.batch130.entity.concretes.EntryComment;
import com.batch130.entity.concretes.User;
import com.batch130.entity.enums.VoteType;
import com.batch130.payload.request.abstracts.BaseEntityRequest;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EntryCommentVoteRequest extends BaseEntityRequest implements Serializable {

    private User createdBy;


    private VoteType voteType;


    private EntryComment entryComment;


}
