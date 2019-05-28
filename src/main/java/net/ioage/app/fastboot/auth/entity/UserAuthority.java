package net.ioage.app.fastboot.auth.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author fastboot
 * @since 2019-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private String authorityName;


}
