package me.liliput.api.controller.model.response;

import lombok.*;
import me.liliput.api.domain.ShortUrl;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShortUrlResponse {
    private ShortUrl shortUrl;
}
