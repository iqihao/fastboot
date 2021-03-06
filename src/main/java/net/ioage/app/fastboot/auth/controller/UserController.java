package net.ioage.app.fastboot.auth.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import net.ioage.app.fastboot.auth.AuthoritiesConstants;
import net.ioage.app.fastboot.auth.SecurityUtils;
import net.ioage.app.fastboot.auth.controller.vm.ManagedUserVM;
import net.ioage.app.fastboot.auth.controller.vm.UserInfoVM;
import net.ioage.app.fastboot.auth.entity.User;
import net.ioage.app.fastboot.auth.service.IUserService;
import net.ioage.app.fastboot.auth.service.dto.UserDTO;
import net.ioage.app.fastboot.common.entity.QueryRequest;
import net.ioage.app.fastboot.common.entity.ReturnItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fastboot
 * @since 2019-05-26
 */
@RestController
@RequestMapping("/api/auth/user")
public class UserController {

    @Resource
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "user-info", method = RequestMethod.GET)
    public ResponseEntity getUserInfo(){
        Optional<User> user = userService.getCurrentUserInfo();
        if (user.isPresent()){
            User userInfo = user.get();
            List<String> roles  = new ArrayList<>();
            userInfo.getAuthorities().forEach(s->roles.add(s.getName()));
            UserInfoVM userInfoVM = new UserInfoVM().setName(userInfo.getFirstName())
                    .setAvatar(userInfo.getImageUrl()).setRoles(roles);
            return new ResponseEntity<>(userInfoVM,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("找不到对应的用户信息",HttpStatus.UNAUTHORIZED);
        }
    }

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity getUserList(QueryRequest request, UserDTO user){
        IPage<UserDTO> userDTOIPage = userService.findUsers(request,user);
        return new ResponseEntity<>(new ReturnItem<>(userDTOIPage),HttpStatus.OK);
    }
}
