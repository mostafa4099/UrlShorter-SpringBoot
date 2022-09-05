package com.mostafa.repo;

import com.mostafa.entity.UrlShorter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 9/5/2022
 */
@Repository
public interface UrlShorterRepo extends JpaRepository<UrlShorter, Long> {
    UrlShorter findByFullUrl(String url);
    UrlShorter findByShortUrl(String code);
}
