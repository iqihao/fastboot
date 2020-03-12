package net.ioage.app.fastboot.auth.service;

import net.ioage.app.fastboot.auth.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Optional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fastboot
 * @since 2019-05-26
 */
public interface IUserService extends IService<User> {

    Optional<User> getUserWithAuthByLogin(String login);

    Optional<User> getUserWithAuthByEmail(String email);

    Optional<User> getCurrentUserInfo();

}
