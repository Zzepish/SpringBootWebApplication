package com.zzepish.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "product")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date releaseDate;
    private boolean isAvailable;
    private int stockQuantity;

    private String imageName;
    private String imageType;

    @Lob // Large binary object
    private byte[] imageBlob;
}
