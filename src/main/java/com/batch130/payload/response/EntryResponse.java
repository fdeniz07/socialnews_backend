package com.batch130.payload.response;


import com.batch130.entity.enums.VoteType;
import com.batch130.payload.response.abstracts.BaseEntityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
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
