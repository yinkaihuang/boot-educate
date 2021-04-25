package cn.educate.boot.demo;

import cn.educate.boot.demo.model.vo.UserQuery;
import cn.educate.boot.demo.model.vo.UserVO;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;


@SpringBootTest
@AutoConfigureMockMvc
class BootstrapApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    /**
     * 测试WEB添加
     */
    @Test
    public void testAdd() {
        UserVO userVO = new UserVO();
        userVO.setName("测试2");
        userVO.setBirthDay(new Date());
        userVO.setGender(1);
        userVO.setIdentityCard("431523200302156992");
        userVO.setRemark("这是测试添加");
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .post("/user/add")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(JSON.toJSONString(userVO))
                    .accept(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("code:0"))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 测试WEB更新
     */
    @Test
    public void testUpdate() {
        UserVO userVO = new UserVO();
        userVO.setId(3L);
        userVO.setName("测试2");
        userVO.setBirthDay(new Date());
        userVO.setGender(1);
        userVO.setIdentityCard("431523200302156992");
        userVO.setRemark("这是测试添加");
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .post("/user/update")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(JSON.toJSONString(userVO)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("code:0"))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 测试WEB删除
     */
    @Test
    public void testDelete() {
        UserQuery query = new UserQuery();
        query.setId(4L);
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .post("/user/delete")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(JSON.toJSONString(query))
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("code:0"))
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 测试WEB查询
     */
    @Test
    public void testList(){
        UserQuery query = new UserQuery();
        query.setName("测试");
        try {
            mockMvc.perform(MockMvcRequestBuilders
                    .post("/user/listUser")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(JSON.toJSONString(query))
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
