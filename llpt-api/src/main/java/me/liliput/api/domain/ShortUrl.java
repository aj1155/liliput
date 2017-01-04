package me.liliput.api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@Entity
@Table(name = "SHORT_URL")
@Getter
@Setter
@ToString
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
    @Column(name = "DESCRIPTION")
    private String description;
}
