package com.kodluyoruz.weekfourjpa.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUpdateProductRequest {
    private String name;
    private String description;
    private Double price;
}
