package com.batch130.payload.response;

import com.batch130.entity.concretes.EntryComment;
import com.batch130.entity.concretes.User;
import com.batch130.entity.enums.VoteType;
import com.batch130.payload.response.abstracts.BaseEntityResponse;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
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
public class EntryCommentVoteResponse extends BaseEntityResponse implements Serializable {

    private User createdBy;

    private VoteType voteType;

    private EntryComment entryComment;
}
