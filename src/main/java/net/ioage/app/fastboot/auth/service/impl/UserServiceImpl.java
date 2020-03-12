package net.ioage.app.fastboot.auth.service.impl;

import net.ioage.app.fastboot.auth.SecurityUtils;
import net.ioage.app.fastboot.auth.entity.User;
import net.ioage.app.fastboot.auth.mapper.UserMapper;
import net.ioage.app.fastboot.auth.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fastboot
 * @since 2019-05-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Optional<User> getUserWithAuthByLogin(String login) {
        return getBaseMapper().getUserWithAuthByLogin(login);
    }

    @Override
    public Optional<User> getUserWithAuthByEmail(String email) {
        return getBaseMapper().getUserWithAuthByEmail(email);
    }

    @Override
    public Optional<User> getCurrentUserInfo() {
        Optional<String> user =  SecurityUtils.getCurrentUserLogin();
        if (user.isPresent()){
            return getUserWithAuthByLogin(user.get());
        }
        return Optional.empty();
    }
}
