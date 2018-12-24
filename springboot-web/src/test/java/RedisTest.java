import com.lvxiao.SpringBootStarter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Author lvxiao
 * Date 2018-12-24 23:52
 * Description: TODO
 * Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStarter.class)
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        Long start = System.currentTimeMillis();
//        List list = (List) redisTemplate.executePipelined(new RedisCallback<Object>() {
//            @Override
//            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                for (int i = 0; i < 100000; i++) {
//                    String key = "Key_" + i;
//                    byte[] rawKey = redisTemplate.getDefaultSerializer().serialize(key);
//                    redisConnection.setEx(rawKey, 36000, redisTemplate.getDefaultSerializer().serialize("vValue"+ i));
//                }
//                return null;
//            }
//        });
        for (int i = 0; i < 100000; i++) {
            int finalI = i;
            redisTemplate.execute(new RedisCallback() {
                @Override
                public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    String key = "Key_" + finalI;
                    byte[] rawKey = redisTemplate.getDefaultSerializer().serialize(key);
                    redisConnection.setEx(rawKey, 36000, redisTemplate.getDefaultSerializer().serialize("vValue"+ finalI));
                    return null;
                }
            });
        }
        Long end = System.currentTimeMillis();
        System.out.println("程序运行时间： "+(end-start)+"ms");
    }
}
