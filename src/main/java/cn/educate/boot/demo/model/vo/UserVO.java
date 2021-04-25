package cn.educate.boot.demo.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author yinchong
 * @create 2021/4/25 9:28
 * @description
 */
@Data
public class UserVO {
    private Long id;
    /**
     * 用户姓名
     **/
    private String name;
    /**
     * 身份证
     **/
    private String identityCard;
    /**
     * 性别 1 男 2 女 3未知
     **/
    private Integer gender;
    /**
     * 出生日期
     **/
    private Date birthDay;
    /**
     * 备注
     **/
    private String remark;
}
