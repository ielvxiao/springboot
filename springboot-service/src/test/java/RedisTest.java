import com.lvxiao.domain.User;
import com.lvxiao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Author lvxiao
 * Date 2018-12-08 20:26
 * Description: TODO
 * Version V1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application.properties")
public class RedisTest {
    @Resource
    private UserService userService;
    @Test
    public void testDefaultSettings() {
        User user = userService.selectUserById(1);
    }
}
