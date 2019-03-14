package cc.zody.yingxiao.controller;

import cc.zody.yingxiao.dataobject.IndexImg;
import cc.zody.yingxiao.enums.DdResultCodeEnum;
import cc.zody.yingxiao.model.DdResult;
import cc.zody.yingxiao.service.IndexImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页轮播图案
 *
 * @author liumin
 * @since 2019-03-13
 */
@RestController
@RequestMapping("/indexImg")
public class IndexImgController {

    @Autowired
    IndexImgService indexImgService;

    @RequestMapping(value = "/all")
    public DdResult queryAllIndexImg() {
        DdResult<List<IndexImg>> result = DdResult.getSuccessResult();
        try {
            result.setData(indexImgService.queryAllIndexImg());
        } catch (Exception e) {
            e.printStackTrace();
            result = DdResult.getFailureResult(DdResultCodeEnum.UNKNOW_EXCEPTION.code(), DdResultCodeEnum.UNKNOW_EXCEPTION.name());

        }
        return result;
    }

    @RequestMapping(value = "/add")
    public DdResult addIndexImg() {
        DdResult<String> result = DdResult.getSuccessResult();
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }





}
