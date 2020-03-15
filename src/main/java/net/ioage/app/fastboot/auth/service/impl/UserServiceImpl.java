package net.ioage.app.fastboot.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.ioage.app.fastboot.auth.SecurityUtils;
import net.ioage.app.fastboot.auth.controller.vm.ManagedUserVM;
import net.ioage.app.fastboot.auth.entity.User;
import net.ioage.app.fastboot.auth.mapper.UserMapper;
import net.ioage.app.fastboot.auth.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.ioage.app.fastboot.auth.service.dto.UserDTO;
import net.ioage.app.fastboot.common.entity.QueryRequest;
import net.ioage.app.fastboot.common.utils.SortUtil;
import net.ioage.app.fastboot.config.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
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
        Optional<String> user = SecurityUtils.getCurrentUserLogin();
        if (user.isPresent()) {
            return getUserWithAuthByLogin(user.get());
        }
        return Optional.empty();
    }

    public IPage<UserDTO> findUsers(QueryRequest queryRequest, UserDTO userDTO) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.likeLeft(null != userDTO.getLogin(),User::getLogin,userDTO.getLogin());
        queryWrapper.likeLeft(null!=userDTO.getEmail(),User::getEmail,userDTO.getEmail());
        Page<User> page = new Page<>(queryRequest.getPageNum(), queryRequest.getPageSize());
        SortUtil.handlePageSort(queryRequest, page, "id", Constants.ORDER_ASC, false);
        IPage<User> userIPage = this.page(page, queryWrapper);
        IPage<UserDTO> userDTOIPage = userIPage.convert(UserDTO::new);
        return userDTOIPage;
    }
}
