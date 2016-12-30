package me.liliput.api.service;

import me.liliput.api.controller.model.request.RouteRequest;
import me.liliput.api.domain.RouteLog;
import me.liliput.api.repository.RouteLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 1002731 on 2016. 12. 31..
 * Email : eenan@sk.com
 */
@Service
public class RouteLogService {

    @Autowired
    private RouteLogRepository routeLogRepository;

    public Long createRouteLog(RouteRequest routeRequest){

        RouteLog routeLog = new RouteLog();
        routeLog.setPath(routeRequest.getPath());
        routeLog.setUserAgent(routeRequest.getUserAgent());
        routeLog.setReferer(routeRequest.getReferer());
        routeLog.setRemoteAddress(routeRequest.getRemoteAddress());

        this.routeLogRepository.save(routeLog);

        return routeLog.getId();
    }
}
