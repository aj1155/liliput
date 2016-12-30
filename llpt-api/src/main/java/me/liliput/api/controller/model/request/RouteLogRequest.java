package me.liliput.api.controller.model.request;

import com.google.common.base.Strings;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
public class RouteLogRequest {

    private final String path;
    private final String userAgent;
    private final String referer;
    private final String remoteAddress;
    private final String query;

    public RouteLogRequest(String path, String userAgent) throws UnsupportedEncodingException {
        this(path, userAgent, null, null, null);
    }

    public RouteLogRequest(String path, String userAgent, String referer, String remoteAddress, String query) throws UnsupportedEncodingException {
        this.path = Strings.nullToEmpty(path);
        this.userAgent = Strings.nullToEmpty(userAgent);
        this.referer = Strings.nullToEmpty(referer);
        this.remoteAddress = Strings.nullToEmpty(remoteAddress);
        this.query = URLDecoder.decode(Strings.nullToEmpty(query), "utf-8");
    }

    public String getPath() {
        if(isRootPath()) {
            return "";
        }

        if(isStatusPath()) {
            return path.substring(1, path.length() - 1);
        }

        return path.startsWith("/") ? path.substring(1) : path;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getReferer() {
        return referer;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public String getQuery() { return query; }

    public boolean isRootPath() {
        return "/".equals(path);
    }

    public boolean isStatusPath() {
        return path.charAt(path.length() - 1) == '+';
    }

    @Override
    public String toString() {
        return "RouteLogRequest{" +
                "path='" + path + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", referer='" + referer + '\'' +
                ", remoteAddress='" + remoteAddress + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}
