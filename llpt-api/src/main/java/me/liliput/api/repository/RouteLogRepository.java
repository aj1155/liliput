package me.liliput.api.repository;

import me.liliput.api.domain.RouteLog;
import me.liliput.api.domain.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 1002731 on 2016. 12. 31..
 * Email : eenan@sk.com
 */
@Repository
public interface RouteLogRepository extends JpaRepository<RouteLog, Long>{

    @Query("SELECT r FROM RouteLog r WHERE r.path = :path")
    List<RouteLog> findByPath(@Param("path") String path);
}
