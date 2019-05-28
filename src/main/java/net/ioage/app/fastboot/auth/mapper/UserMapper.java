package net.ioage.app.fastboot.auth.mapper;

import net.ioage.app.fastboot.auth.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fastboot
 * @since 2019-05-26
 */
public interface UserMapper extends BaseMapper<User> {
    Optional<User> getUserWithAuthByLogin(@Param("login") String login);

    Optional<User> getUserWithAuthByEmail(@Param("email") String email);
}
