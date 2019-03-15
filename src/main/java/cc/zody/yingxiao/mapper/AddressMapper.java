package cc.zody.yingxiao.mapper;

import cc.zody.yingxiao.dataobject.Address;
import cc.zody.yingxiao.dataobject.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {

    Integer insertAddress(Address address);

    Integer delAddress(Address address);

    Integer updateAddress(Address address);


    List<Address> selectUserAllAddress(User user);

    Address selectById(Integer id);



}
