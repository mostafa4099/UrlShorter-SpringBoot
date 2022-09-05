package com.mostafa.service;

import com.google.common.hash.Hashing;
import com.mostafa.Model.UrlShorterModel;
import com.mostafa.entity.UrlShorter;
import com.mostafa.repo.UrlShorterRepo;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 9/5/2022
 */
@Service
public class UrlShorterServiceImpl implements UrlShorterService {

    @Autowired
    private UrlShorterRepo urlShorterRepo;

    /**
     * Generate encoded Url using google guava library's murmur3_32() encryption method
     * and save it in db with original one.
     * @param url
     * @return Shorted Url model
     */
    @Override
    public UrlShorterModel shortUrl(String url) {
        UrlShorterModel model = new UrlShorterModel();
        UrlShorter shorter = new UrlShorter();

        UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});

        if (!urlValidator.isValid(url)) {
            throw new RuntimeException("Invalid Url: " + url);
        }

        UrlShorter urlShorter = urlShorterRepo.findByFullUrl(url);

        if(null != urlShorter){
            model = model.setUrlShorterModel(urlShorter);
            return model;
        }

        String shortCode = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
        shorter.setFullUrl(url);
        shorter.setShortUrl(shortCode);

        shorter = urlShorterRepo.save(shorter);

        if(null != shorter) {
            model = model.setUrlShorterModel(shorter);
        }

        return model;
    }

    /**
     * retrieve original url using provided encoded one
     * @param code
     * @return Url Shorter
     */
    @Override
    public UrlShorter getByShortUrl(String code) {
        return urlShorterRepo.findByShortUrl(code);
    }
}
