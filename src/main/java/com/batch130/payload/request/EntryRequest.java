package com.batch130.payload.request;


import com.batch130.entity.concretes.*;
import com.batch130.entity.enums.VoteType;
import com.batch130.payload.request.abstracts.BaseEntityRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EntryRequest extends BaseEntityRequest implements Serializable {


    @NotNull(message = "The subject can not be empty")
    @NotBlank
    @Size(min = 2, max = 100, message = "Your entry name should be at least 2 chars")
    private String subject;


    @NotNull(message = "The content can not be empty")
    @Size(min = 20, message = "The Content should be at least 20 chars" )
    private String content;


/*
    private VoteType voteType;
*/

   /*
    @NotNull(message = "The viewCount can not be empty")
    @NotBlank
    private Integer viewCount;

    @NotNull(message = "The commentCount can not be empty")
    @NotBlank
    private Integer commentCount;

    @NotNull(message = "The thumbnail can not be empty")
    @NotBlank
    private String thumbnail;

    @NotNull(message = "The seoAuthor can not be empty")
    @NotBlank
    private String seoAuthor;
    @NotNull(message = "The seoEntry can not be empty")
    @NotBlank
    private String seoEntry;
    @NotNull(message = "The seoTags can not be empty")
    @NotBlank
    private String seoTags;

*/
}
