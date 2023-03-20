package com.example.demo.dto;

import com.example.demo.model.TestRequestBodyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestRequestBodyDTO {
    private int id;
    private String message;
    public TestRequestBodyDTO(final TestRequestBodyEntity entity){
        this.id= entity.getId();
        this.message= entity.getMessage();
    }
}
