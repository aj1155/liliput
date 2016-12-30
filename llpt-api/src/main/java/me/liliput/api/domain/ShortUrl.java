package me.liliput.api.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@Entity
@Table(name = "SHORT_URL")
public class ShortUrl extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "HOST_DOMAIN")
    private String domain;
    @Column(name = "PATH")
    private String path;
    @Column(name = "ORIGIN_URL")
    private String originUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "id=" + id +
                ", domain='" + domain + '\'' +
                ", path='" + path + '\'' +
                ", originUrl='" + originUrl + '\'' +
                '}';
    }
}
