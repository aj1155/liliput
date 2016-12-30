package me.liliput.api.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 1002731 on 2016. 12. 31..
 * Email : eenan@sk.com
 */
@Entity
@Table(name = "ROUTE_LOG")
public class RouteLog extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PATH")
    private String path;
    @Column(name = "USER_AGENT")
    private String userAgent;
    @Column(name = "REFERER")
    private String referer;
    @Column(name = "REMOTE_ADDRESS")
    private String remoteAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    @Override
    public String toString() {
        return "RouteLog{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", referer='" + referer + '\'' +
                ", remoteAddress='" + remoteAddress + '\'' +
                '}';
    }
}
