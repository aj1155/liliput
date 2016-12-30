package me.liliput.api.controller.model.response;

import lombok.*;
import me.liliput.api.domain.RouteLog;

/**
 * Created by 1002731 on 2016. 12. 31..
 * Email : eenan@sk.com
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RouteLogResponse {
    private RouteLog routeLog;
}
