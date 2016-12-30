package me.liliput.api.repository;

import me.liliput.api.domain.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long>{
}
