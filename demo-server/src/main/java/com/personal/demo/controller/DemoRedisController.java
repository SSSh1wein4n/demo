package com.personal.demo.controller;

import com.personal.demo.constants.JsonResult;
import com.personal.demo.service.DemoRedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis示例接口
 *
 * @author shiweinan
 * @date 2020-08-11 11:00
 */
@RestController
@RequestMapping("demo-redis")
@Api(tags = "swagger示例")
public class DemoRedisController {

    @Autowired
    private DemoRedisService demoRedisService;

    @GetMapping("add")
    @ApiOperation("新增redis数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "key", value = "redis中的key", dataType = "String"),
        @ApiImplicitParam(name = "value", value = "redis中的value", dataType = "String")
    })
    public JsonResult addRedisValue(String key, String value) {
        JsonResult jsonResult = JsonResult.getInstance();
        demoRedisService.addToRedis(key, value);
        jsonResult.addSuccess();
        return jsonResult;
    }

    @GetMapping("find-by-key")
    @ApiOperation("根据key获取redis数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "key", value = "redis中的key", dataType = "String")
    })
    public JsonResult getRedisValue(String key) {
        JsonResult jsonResult = JsonResult.getInstance();
        String value = demoRedisService.findByKey(key);
        jsonResult.addData("data", value);
        jsonResult.querySuccess();
        return jsonResult;
    }

    @GetMapping("modify")
    @ApiOperation("更新redis中的数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "key", value = "redis中的key", dataType = "String"),
        @ApiImplicitParam(name = "value", value = "redis中的value", dataType = "String")
    })
    public JsonResult modifyRedisValue(String key, String value) {
        JsonResult jsonResult = JsonResult.getInstance();
        boolean isSuccess;
        try {
            isSuccess = demoRedisService.modify(key, value);
            if (isSuccess) {
                jsonResult.modifySuccess();
            } else {
                jsonResult.modifyFail();
            }
        } catch (Exception e) {
            jsonResult.modifyFail();
        }
        return jsonResult;
    }



    @GetMapping("remove-by-key")
    @ApiOperation("根据key删除redis数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "key", value = "redis中的key", dataType = "String")
    })
    public JsonResult removeByKey(String key) {
        JsonResult jsonResult = JsonResult.getInstance();
        boolean isSuccess = demoRedisService.removeByKey(key);
        if (isSuccess) {
            jsonResult.removeSuccess();
        } else {
            jsonResult.removeFail();
        }
        return jsonResult;
    }
}
