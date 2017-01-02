package me.liliput.api.controller;

import com.google.common.net.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import me.liliput.api.controller.model.request.RouteLogRequest;
import me.liliput.api.service.RouteLogService;
import me.liliput.api.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@Controller
@Slf4j
public class RoutingController {
    @Autowired
    private UrlPathHelper urlPathHelper;
    @Autowired
    private ShortUrlService shortUrlService;
    @Autowired
    private RouteLogService routeLogService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public void page(HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().print("Welcome to Liliput");
    }

    /*
        Todo 라우터 기능은 결국엔 분리 필요할듯
     */
    @RequestMapping(value = {"/{path}"}, method = RequestMethod.GET)
    public String get(@PathVariable String path, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RouteLogRequest routeRequest = getRouteRequest(request);
        String originUrl = this.shortUrlService.getOriginUrl(routeRequest.getPath());

        return "redirect:" + originUrl;
    }

    private RouteLogRequest getRouteRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        String path = urlPathHelper.getLookupPathForRequest(request);
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT);
        String referer = request.getHeader(HttpHeaders.REFERER);
        String remoteAddress = request.getRemoteAddr();
        String query = request.getQueryString();
        RouteLogRequest routeLogRequest = new RouteLogRequest(path, userAgent, referer, remoteAddress, query);
        this.routeLogService.createRouteLog(routeLogRequest);

        log.debug(routeLogRequest.toString());
        return routeLogRequest;
    }
}
