package net.ioage.app.fastboot.auth.service.impl;

import net.ioage.app.fastboot.auth.entity.User;
import net.ioage.app.fastboot.auth.mapper.UserMapper;
import net.ioage.app.fastboot.auth.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
