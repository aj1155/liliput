package me.liliput.api.repository;

import me.liliput.api.domain.RouteLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 1002731 on 2016. 12. 31..
 * Email : eenan@sk.com
 */
@Repository
public interface RouteLogRepository extends JpaRepository<RouteLog, Long>{
}
