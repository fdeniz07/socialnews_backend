package com.batch130.payload.response;


import com.batch130.entity.enums.VoteType;
import com.batch130.payload.response.abstracts.BaseEntityResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EntryResponse extends BaseEntityResponse  implements Serializable {


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
