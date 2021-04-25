package cn.educate.boot.demo.web;

import cn.educate.boot.demo.model.dto.UserDTO;
import cn.educate.boot.demo.model.vo.UserQuery;
import cn.educate.boot.demo.model.vo.UserVO;
import cn.educate.boot.demo.service.IUserService;
import cn.educate.boot.demo.util.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author yinchong
 * @create 2021/4/25 9:29
 * @description
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    /***
     * 添加用户
     * @param vo
     * @return
     */
    @RequestMapping("add")
    public Map<String, Object> add(@RequestBody UserVO vo) {
        try {
            log.info("add user vo:{}",vo);
            userService.addUser(vo);
            return BeanUtils.success();
        } catch (Exception e) {
            log.info("add user fail,{} ", vo, e);
            return BeanUtils.fail();
        }
    }

    /**
     * 更新用户
     * @param vo
     * @return
     */
    @RequestMapping("update")
    public Map<String, Object> update(@RequestBody UserVO vo) {
        try {
            userService.updateUser(vo);
            return BeanUtils.success();
        } catch (Exception e) {
            log.info("update user fail,{} ", vo, e);
            return BeanUtils.fail();
        }
    }

    /***
     * 删除用户
     * @param query
     * @return
     */
    @RequestMapping("delete")
    public Map<String, Object> delete(@RequestBody UserQuery query) {
        try {
            userService.deleteUser(query.getId());
            return BeanUtils.success();
        } catch (Exception e) {
            log.info("delete user fail,{} ", query, e);
            return BeanUtils.fail();
        }
    }

    /***
     * 查询用户
     * @param query
     * @return
     */
    @RequestMapping("listUser")
    public Map<String, Object> listUser(@RequestBody UserQuery query) {
        try {
            List<UserDTO> list = userService.listUser(query);
            return BeanUtils.success(list);
        } catch (Exception e) {
            log.info("query user list fail,{} ", query, e);
            return BeanUtils.fail();
        }
    }
}
