package com.mostafa.service;

import com.mostafa.Model.UrlShorterModel;
import com.mostafa.entity.UrlShorter;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 9/5/2022
 */
public interface UrlShorterService {
    UrlShorterModel shortUrl(String url);

    UrlShorter getByShortUrl(String code);
}
