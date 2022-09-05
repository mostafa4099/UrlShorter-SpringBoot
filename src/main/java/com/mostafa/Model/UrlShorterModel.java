package com.mostafa.Model;

import com.mostafa.entity.UrlShorter;
import lombok.*;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 9/5/2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UrlShorterModel {
    private Long id;
    private String fullUrl;
    private String shortUrl;

    public UrlShorterModel setUrlShorterModel(UrlShorter urlShorter) {
        this.fullUrl = urlShorter.getFullUrl();
        this.shortUrl = "http://localhost:9090/api/"+urlShorter.getShortUrl();
        return this;
    }
}
