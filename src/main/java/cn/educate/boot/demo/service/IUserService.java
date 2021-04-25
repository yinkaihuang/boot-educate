package cn.educate.boot.demo.service;

import cn.educate.boot.demo.model.dto.UserDTO;
import cn.educate.boot.demo.model.vo.UserQuery;
import cn.educate.boot.demo.model.vo.UserVO;

import java.util.List;

public interface IUserService {

    void addUser(UserVO vo);

    void updateUser(UserVO vo);

    void deleteUser(Long id);

    List<UserDTO> listUser(UserQuery query);
}
