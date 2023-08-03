package com.batch130.payload.response.abstracts;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class BaseEntityResponse {


    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private boolean isActive;





}
