package net.ioage.app.fastboot.common.entity;

import lombok.Data;

/**
 * Created by qihao01 on 2020/3/13.
 */
@Data
public class ReturnItem<T> {
    public ReturnItem(T data) {
        Data = data;
        Code = 0;
    }

    public ReturnItem(int code, String msg) {
        Code = code;
        Msg = msg;
    }

    public ReturnItem(int code, String msg, T data) {
        Code = code;
        Msg = msg;
        Data = data;
    }

    private int Code;
    private String Msg;
    private T Data;
}
