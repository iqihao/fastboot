package net.ioage.app.fastboot.auth.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fastboot
 * @since 2019-05-26
 */
@Controller
@RequestMapping("/auth/user")
public class UserController {

    @ResponseBody
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public ResponseEntity test(){
        return new ResponseEntity("123", HttpStatus.OK);
    }
}
