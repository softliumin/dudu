package cc.zody.yingxiao.service;

import cc.zody.yingxiao.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author liumin
 * @since 2019-03-08
 */
@Service
public class AddressService {

    @Autowired
    AddressMapper addressMapper;

}
