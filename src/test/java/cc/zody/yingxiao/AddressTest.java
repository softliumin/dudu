package cc.zody.yingxiao;

import cc.zody.yingxiao.dataobject.Address;
import cc.zody.yingxiao.dataobject.User;
import cc.zody.yingxiao.mapper.AddressMapper;
import com.alibaba.fastjson.JSON;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author liumin
 * @since 2019-03-12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {

    @Autowired
    AddressMapper addressMapper;


    @Ignore
    @Test
    public void testAdd() {
        Address address = new Address();
        address.setName("liumin2");
        address.setTelNum("1102");
        address.setUserId(10);
        address.setMainAddress("city2");
        address.setDetailAddress("ro2ad");
        Integer result = addressMapper.insertAddress(address);
        System.out.println(result);
    }

    @Ignore
    @Test
    public void testUpdate() {
        Address address = new Address();
        address.setId(1);
        address.setName("huha010");
        Integer result = addressMapper.updateAddress(address);
        System.out.println(result);
    }

    @Ignore
    @Test
    public void testQuery() {
        User user = new User();
        user.setId(10);
        List<Address> list = addressMapper.selectUserAllAddress(user);
        System.out.println("====================" + JSON.toJSON(list));
    }

    @Ignore
    @Test
    public void testDel() {
        Address address = new Address();
        address.setId(1);
        Integer result = addressMapper.delAddress(address);
        System.out.println(result);
    }
}
