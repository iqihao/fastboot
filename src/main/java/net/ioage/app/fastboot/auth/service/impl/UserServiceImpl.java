package net.ioage.app.fastboot.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.ioage.app.fastboot.auth.entity.Authority;
import net.ioage.app.fastboot.auth.entity.User;
import net.ioage.app.fastboot.auth.mapper.AuthorityMapper;
import net.ioage.app.fastboot.auth.mapper.UserMapper;
import net.ioage.app.fastboot.auth.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fastboot
 * @since 2019-05-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private AuthorityMapper authorityMapper;

//    User findOneWithAuthoritiesByEmail(String email){
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("email",email);
//        User user = userMapper.selectOne(queryWrapper);
//        List<Authority> authorities = authorityMapper.
//    }
}
