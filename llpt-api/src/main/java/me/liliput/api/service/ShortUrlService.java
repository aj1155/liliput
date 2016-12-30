package me.liliput.api.service;

import me.liliput.api.controller.model.request.ShortUrlRequest;
import me.liliput.api.domain.ShortUrl;
import me.liliput.api.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@Service
public class ShortUrlService {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    public Long createShortUrl(ShortUrlRequest shortUrlRequest){
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setDomain(shortUrlRequest.getDomain());
        shortUrl.setPath(shortUrlRequest.getPath());
        shortUrl.setOriginUrl(shortUrlRequest.getOriginUrl());

        this.shortUrlRepository.save(shortUrl);

        return shortUrl.getId();
    }
}
