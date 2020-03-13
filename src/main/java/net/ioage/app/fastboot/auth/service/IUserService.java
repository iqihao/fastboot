package net.ioage.app.fastboot.auth.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import net.ioage.app.fastboot.auth.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import net.ioage.app.fastboot.auth.service.dto.UserDTO;
import net.ioage.app.fastboot.common.entity.QueryRequest;

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

    IPage<UserDTO> findUsers(QueryRequest queryRequest, UserDTO userDTO);

}
