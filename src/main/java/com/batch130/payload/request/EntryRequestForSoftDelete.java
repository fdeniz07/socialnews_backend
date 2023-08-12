package com.batch130.payload.request;


import com.batch130.entity.enums.VoteType;
import com.batch130.payload.request.abstracts.BaseEntityRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class EntryRequestForSoftDelete extends BaseEntityRequest implements Serializable {

    private String subject;

    private String content;

    private VoteType voteType;

    private Integer viewCount;

    private Integer commentCount;

    private String thumbnail;

    private String seoAuthor;

    private String seoEntry;

    private String seoTags;

}
