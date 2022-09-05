package com.mostafa.controller;

import com.mostafa.Model.UrlShorterModel;
import com.mostafa.entity.UrlShorter;
import com.mostafa.service.UrlShorterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @CreationDate 9/5/2022
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UrlShorterServiceImpl urlShorterService;

    /**
     * Generate encoded Url and save it in db with original one
     * @param url
     * @return Shorted Url model
     */
    @PostMapping({"/"})
    public UrlShorterModel shortUrl(@RequestParam String url) {
        return urlShorterService.shortUrl(url);
    }

    /**
     * retrieve original url using provided encoded one
     * and redirect to original one
     * @param code
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping({"/{code}"})
    public ResponseEntity<?> redirectUrl(
            @PathVariable String code,
            HttpServletResponse response) throws IOException {
        UrlShorter urlShorter = urlShorterService.getByShortUrl(code);
        if(urlShorter == null){
            return new ResponseEntity<String>("URL not found!", HttpStatus.OK);
        }
        response.sendRedirect(urlShorter.getFullUrl());
        return null;
    }
}
