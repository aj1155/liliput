package me.liliput.api.controller.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import me.liliput.api.domain.ShortUrl;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShortUrlResponse {
    private ShortUrl shortUrl;
}
