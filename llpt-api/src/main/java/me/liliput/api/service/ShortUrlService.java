package me.liliput.api.service;

import me.liliput.api.controller.model.request.ShortUrlRequest;
import me.liliput.api.controller.model.response.ShortUrlResponse;
import me.liliput.api.domain.ShortUrl;
import me.liliput.api.repository.ShortUrlRepository;
import me.liliput.api.util.builder.PathBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@Service
public class ShortUrlService {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    @Autowired
    private PathBuilder pathBuilder;

    public ShortUrlResponse createShortUrl(ShortUrlRequest shortUrlRequest) {
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setDomain(shortUrlRequest.getDomain());

        String randomPath = this.pathBuilder.setWebUrl(shortUrlRequest.getOriginUrl()).shorten(this.pathBuilder.getPathGenerateSource(), 6);
        shortUrl.setPath(randomPath);
        shortUrl.setOriginUrl(shortUrlRequest.getOriginUrl());

        this.shortUrlRepository.save(shortUrl);

        ShortUrlResponse shortUrlResponse = new ShortUrlResponse();
        shortUrlResponse.setShortUrl(shortUrl);

        return shortUrlResponse;
    }

    public List<ShortUrlResponse> getShortUrls() {
        List<ShortUrl> shortUrlList = this.shortUrlRepository.findAll();

        List<ShortUrlResponse> shortUrlResponseList = new ArrayList<>();
        shortUrlList.forEach(shortUrl -> {
            shortUrlResponseList.add(new ShortUrlResponse(shortUrl));
        });

        return shortUrlResponseList;
    }

    public String getOriginUrl(String path) {
        String originUrl = this.shortUrlRepository.findByOriginUrl(path);
        if (originUrl == null) {
            return "/";
        } else {
            return originUrl;
        }
    }
}
