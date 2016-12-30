package me.liliput.api.controller.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShortUrlRequest {
    private Long id;
    private String domain;
    private String path;
    private String originUrl;
}
