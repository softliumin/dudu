package cc.zody.yingxiao.service;

import cc.zody.yingxiao.dataobject.Address;
import cc.zody.yingxiao.dataobject.User;
import cc.zody.yingxiao.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author liumin
 * @since 2019-03-08
 */
@Service
public class AddressService {

    @Autowired
    AddressMapper addressMapper;


    public List<Address> queryAddressByUid(Integer uid){
        User user  = new User();
        user.setId(uid);
        return addressMapper.selectUserAllAddress(user);
    }

    public Address selectById(Integer id){
        return addressMapper.selectById(id);
    }

}
