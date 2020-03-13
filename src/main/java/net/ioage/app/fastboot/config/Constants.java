package net.ioage.app.fastboot.config;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String ANONYMOUS_USER = "anonymoususer";
    public static final String DEFAULT_LANGUAGE = "zh-cn";
    public static final String MOBILE_REG = "[1]\\d{10}";
    // 排序规则：降序
    public static final String ORDER_DESC = "desc";
    // 排序规则：升序
    public static final String ORDER_ASC = "asc";
    
    private Constants() {
    }
}
