package com.batch130.payload.mappers;


import com.batch130.entity.concretes.Entry;
import com.batch130.entity.concretes.EntryComment;
import com.batch130.entity.concretes.EntryCommentVote;
import com.batch130.payload.request.EntryCommentVoteRequest;
import com.batch130.payload.request.EntryRequest;
import com.batch130.payload.response.EntryCommentVoteResponse;
import com.batch130.payload.response.EntryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntryCommentVoteMapper {

    @Autowired
    private  ModelMapper modelMapper;

    public EntryCommentVoteResponse convertEntryCommentVoteToResponse(EntryCommentVote entryCommentVote){

        return modelMapper.map(entryCommentVote, EntryCommentVoteResponse.class);
    }


        public EntryCommentVote convertRequestToEntryCommentVote(EntryCommentVoteRequest request){
        EntryCommentVote commentVote = modelMapper.map(request, EntryCommentVote.class);
        commentVote.setActive(true);
        commentVote.setDeleted(false);
        return commentVote;
    }

}
