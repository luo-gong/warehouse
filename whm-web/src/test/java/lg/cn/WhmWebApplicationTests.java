package lg.cn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lg.cn.whmmember.service.UserService;
import lg.cn.whmmember.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class WhmWebApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() throws JsonProcessingException {
        PageRequest pageRequest = PageRequest.of(0, 1);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "luogong");
        map.put("userId", "1");
        map.put("rid", "1");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("记录》》》" + objectMapper.writeValueAsString(userService.getPage(pageRequest, map).getContent()));
    }

    @Test
    void findUserById() throws JsonProcessingException {
        PageRequest pageRequest = PageRequest.of(0, 1);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("记录》》》" +
                objectMapper.writeValueAsString(userService.findUserById(1)));
    }

    @Test
    void deleteUserById() {
        System.out.println("deleteUserById>>>" + userService.deleteUserById(4));
    }



}
