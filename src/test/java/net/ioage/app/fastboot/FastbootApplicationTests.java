package net.ioage.app.fastboot;

import net.ioage.app.fastboot.auth.entity.User;
import net.ioage.app.fastboot.auth.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastbootApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getUserInfo(){
        Optional<User> user = userMapper.getUserWithAuthByLogin("asg");
        System.out.print(user.toString());
    }

}
