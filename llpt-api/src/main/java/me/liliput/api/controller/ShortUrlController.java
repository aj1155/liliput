package me.liliput.api.controller;

import me.liliput.api.controller.model.request.ShortUrlRequest;
import me.liliput.api.controller.model.response.LlptApiResponse;
import me.liliput.api.controller.model.response.ShortUrlResponse;
import me.liliput.api.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
    public LlptApiResponse<ShortUrlResponse> createShortUrl(@Valid @RequestBody ShortUrlRequest shortUrlRequest) {
        ShortUrlResponse shortUrlResponse = this.shortUrlService.createShortUrl(shortUrlRequest);
        return new LlptApiResponse(shortUrlResponse);
    }

    @RequestMapping(value = {"/url/all"}, method = RequestMethod.GET)
    public LlptApiResponse<List<ShortUrlResponse>> readShortUrls(){
        return new LlptApiResponse(this.shortUrlService.getShortUrls());
    }
}
