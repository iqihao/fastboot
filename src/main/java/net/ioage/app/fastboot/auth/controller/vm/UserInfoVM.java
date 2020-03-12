package net.ioage.app.fastboot.auth.controller.vm;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by qihao01 on 2020/3/12.
 */
@Data
@Accessors(chain = true)
public class UserInfoVM {
    private String name;
    private String avatar;
    private String introduction;
    private List<String> roles;
}
