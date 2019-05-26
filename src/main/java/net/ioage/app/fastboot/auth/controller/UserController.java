package net.ioage.app.fastboot.auth.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.Optional;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fastboot
 * @since 2019-05-24
 */
@Controller
@RequestMapping("/auth/user")
public class UserController {
    @GetMapping("/users")
    public ResponseEntity<String> users() {
        return new ResponseEntity<String>("hello user", HttpStatus.OK);
    }
}
