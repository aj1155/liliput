package me.liliput.api.controller;

import me.liliput.api.controller.model.request.ShortUrlRequest;
import me.liliput.api.controller.model.response.LlptApiResponse;
import me.liliput.api.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@RestController
@RequestMapping("/api/v1/shorten")
public class ShortUrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @RequestMapping(value = {"/url"}, method = RequestMethod.POST)
    public LlptApiResponse createShortUrl(@Valid @RequestBody ShortUrlRequest shortUrlRequest) {
        System.out.println(shortUrlRequest.toString());
        Long id = this.shortUrlService.createShortUrl(shortUrlRequest);
        return new LlptApiResponse(id);
    }
}
