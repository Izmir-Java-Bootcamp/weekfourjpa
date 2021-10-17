package com.kodluyoruz.weekfourjpa.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Size(max = 100)
    @Column(unique = true, length = 100, nullable = false)
    private String name;

    @NotBlank
    @Size(max = 150)
    @Column(length = 150, nullable = false)
    private String description;

    @Min(1)
    @Column(nullable = false)
    private Double price;

    private Date creationDate;
    private Date lastModificationDate;
    private Boolean deleted;


}
