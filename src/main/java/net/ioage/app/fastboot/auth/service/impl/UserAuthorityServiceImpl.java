package net.ioage.app.fastboot.auth.service.impl;

import net.ioage.app.fastboot.auth.entity.UserAuthority;
import net.ioage.app.fastboot.auth.mapper.UserAuthorityMapper;
import net.ioage.app.fastboot.auth.service.IUserAuthorityService;
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
public class UserAuthorityServiceImpl extends ServiceImpl<UserAuthorityMapper, UserAuthority> implements IUserAuthorityService {

}
