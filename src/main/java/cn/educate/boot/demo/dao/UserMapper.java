package cn.educate.boot.demo.dao;

import cn.educate.boot.demo.model.dto.UserDTO;
import cn.educate.boot.demo.model.vo.UserQuery;
import cn.educate.boot.demo.model.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据操作层，这里的实现是resource的mapper文件
 * 框架会根据mapper文件动态创建实现类
 */
public interface UserMapper {

    int addUser(UserVO vo);

    int updateUser(UserVO vo);

    int deleteUser(@Param("id") Long id);

    List<UserDTO> listUser(UserQuery query);
}
