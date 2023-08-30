package com.workintech.plant.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
//entity olarak algılanmasın yani table oluştrumasın diye @MappedSuperClass yazdık
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull
    @NotBlank
    @Size(min=2,max=45,message = "name size must be 0 to 45")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    @DecimalMin("10")
    private double price;

}
