package cn.educate.boot.demo.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yinchong
 * @create 2021/4/25 9:31
 * @description
 */
public class BeanUtils {

    public static Map<String, Object> success() {
        return map(0, "操作成功", null);
    }

    public static Map<String, Object> fail() {
        return fail(500, "操作失败");
    }

    public static Map<String, Object> fail(int code, String msg) {
        return map(code, msg, null);
    }

    public static Map<String, Object> success(Object data) {
        return map(0, "操作成功", data);
    }

    private static Map<String, Object> map(int code, String msg, Object data) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }


}
