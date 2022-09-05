package com.mostafa.entity;

import lombok.*;
import javax.persistence.*;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 9/5/2022
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UrlShorter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    @Lob
    private String fullUrl;
    @Column(unique=true)
    private String shortUrl;
}
