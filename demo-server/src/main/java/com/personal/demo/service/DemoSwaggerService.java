package com.personal.demo.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * swagger示例服务层
 *
 * @author shiweinan
 * @date 2020-07-24 16:24
 */
@Service
public class DemoSwaggerService {

    /**
     * 无参方法测试
     *
     * @return 返回提示语
     */
    public String demoSwagger() {
        return "无参方法返回结果";
    }

    public String paramSwagger(String str) {
        if (StringUtils.isBlank(str)) {
            str = "参数为空的返回";
        }
        return str;
    }
}
