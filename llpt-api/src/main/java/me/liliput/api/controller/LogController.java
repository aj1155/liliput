package me.liliput.api.controller;

import me.liliput.api.controller.model.response.LlptApiResponse;
import me.liliput.api.controller.model.response.RouteLogResponse;
import me.liliput.api.service.RouteLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 1002731 on 2016. 12. 31..
 * Email : eenan@sk.com
 */
@RestController
@RequestMapping(value = "/api/v1/log")
public class LogController {

    @Autowired
    private RouteLogService routeLogService;

    @RequestMapping(value = {"/{path}"}, method = RequestMethod.GET)
    public LlptApiResponse<List<RouteLogResponse>> readRouteLogs(@PathVariable String path) {
        return new LlptApiResponse(this.routeLogService.readRouteLogs(path));
    }
}
