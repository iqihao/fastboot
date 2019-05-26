package net.ioage.app.fastboot.auth.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.ioage.app.fastboot.auth.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fastboot
 * @since 2019-05-24
 */
public interface UserMapper extends BaseMapper<User> {


    int deleteAll(@Param("ew") Long id);

}
