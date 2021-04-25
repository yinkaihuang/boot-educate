package cn.educate.boot.demo.service.impl;

import cn.educate.boot.demo.dao.UserMapper;
import cn.educate.boot.demo.model.dto.UserDTO;
import cn.educate.boot.demo.model.vo.UserQuery;
import cn.educate.boot.demo.model.vo.UserVO;
import cn.educate.boot.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yinchong
 * @create 2021/4/25 9:35
 * @description
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userDao;

    @Override
    public void addUser(UserVO vo) {
        int rowCount = userDao.addUser(vo);
        checkRow(rowCount);
    }

    @Override
    public void updateUser(UserVO vo) {
        int rowCount = userDao.updateUser(vo);
        checkRow(rowCount);
    }

    @Override
    public void deleteUser(Long id) {
      int rowCount = userDao.deleteUser(id);
      checkRow(rowCount);
    }

    @Override
    public List<UserDTO> listUser(UserQuery query) {
        return userDao.listUser(query);
    }


    private void checkRow(int row){
        if(row<=0){
            throw new RuntimeException("操作数据库失败");
        }
    }
}
