package com.batch130.payload.response;

import com.batch130.entity.concretes.Entry;
import com.batch130.payload.response.abstracts.BaseEntityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse extends BaseEntityResponse {

    private String categoryName;

    private List<Entry> entries;

    private String categoryDetails;

}