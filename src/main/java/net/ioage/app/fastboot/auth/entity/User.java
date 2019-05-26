package net.ioage.app.fastboot.auth.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableField;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import java.io.Serializable;
    import java.util.HashSet;
    import java.util.Set;

    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author fastboot
* @since 2019-05-24
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

            @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String login;

    @TableField(value = "password_hash")
    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String imageUrl;

    private Boolean activated;

    private String langKey;

    private String activationKey;

    private String resetKey;

    private String createdBy;

    private LocalDateTime createdDate;

    private LocalDateTime resetDate;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    @TableField(exist = false)
    private Set<Authority> authorities = new HashSet<>();
}
