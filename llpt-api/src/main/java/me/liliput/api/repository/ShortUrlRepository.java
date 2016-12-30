package me.liliput.api.repository;

import me.liliput.api.domain.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long>{

    @Query("SELECT s.originUrl FROM ShortUrl s WHERE s.path = :path")
    String findByOriginUrl(@Param("path") String path);
}
