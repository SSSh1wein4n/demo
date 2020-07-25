package com.personal.demo.controller;

import com.personal.demo.constants.JsonResult;
import com.personal.demo.service.DemoSwaggerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * swagger示例控制层
 *
 * swagger访问地址为：http://localhost:8080/spring-boot-demo-server/swagger-ui.html
 *
 * @author shiweinan
 * @date 2020-07-24 16:24
 */
@RestController
@RequestMapping("demo-swagger")
@Api(tags = "swagger示例")
public class DemoSwaggerController {

    @Autowired
    private DemoSwaggerService demoSwaggerService;

    @GetMapping("demo")
    @ApiOperation("swagger无参示例接口")
    public JsonResult demoSwagger() {
        JsonResult jsonResult = JsonResult.getInstance();
        String message = demoSwaggerService.demoSwagger();
        jsonResult.querySuccess();
        jsonResult.addData("data", message);
        return jsonResult;
    }

    @GetMapping("param-demo")
    @ApiOperation(value = "swagger有参示例接口", notes = "swagger有参示例接口", httpMethod = "GET")
    @ApiImplicitParams(value = {
        @ApiImplicitParam(name = "str", value = "传来的字符串参数")
    })
    public JsonResult paramDemo(String str) {
        JsonResult jsonResult = JsonResult.getInstance();
        String message = demoSwaggerService.paramSwagger(str);
        jsonResult.querySuccess();
        jsonResult.addData("data", message);
        return jsonResult;
    }
}
