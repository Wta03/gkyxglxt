package com.qust.task.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {
    private Integer code;
    private String message;
    private boolean success;
    private Map<String, Object> data = new HashMap<>();

    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(20000);
        msg.setMessage("响应成功");
        msg.setSuccess(true);
        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(10000);
        msg.setMessage("响应失败");
        msg.setSuccess(false);
        return msg;
    }

    public Msg data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Msg code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Msg mess(String str) {
        this.setMessage(str);
        return this;
    }
}
