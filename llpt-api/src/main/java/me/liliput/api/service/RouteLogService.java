package me.liliput.api.service;

import me.liliput.api.controller.model.request.RouteLogRequest;
import me.liliput.api.controller.model.response.RouteLogResponse;
import me.liliput.api.domain.RouteLog;
import me.liliput.api.repository.RouteLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1002731 on 2016. 12. 31..
 * Email : eenan@sk.com
 */
@Service
public class RouteLogService {

    @Autowired
    private RouteLogRepository routeLogRepository;

    public Long createRouteLog(RouteLogRequest routeLogRequest) {

        RouteLog routeLog = new RouteLog();
        routeLog.setPath(routeLogRequest.getPath());
        routeLog.setUserAgent(routeLogRequest.getUserAgent());
        routeLog.setReferer(routeLogRequest.getReferer());
        routeLog.setRemoteAddress(routeLogRequest.getRemoteAddress());

        this.routeLogRepository.save(routeLog);

        return routeLog.getId();
    }

    public List<RouteLogResponse> readRouteLogs(String path) {
        List<RouteLog> routeLogList = this.routeLogRepository.findByPath(path);

        List<RouteLogResponse> routeLogResponseList = new ArrayList<>();
        routeLogList.forEach(routeLog -> {
            routeLogResponseList.add(new RouteLogResponse(routeLog));
        });

        return routeLogResponseList;
    }
}
