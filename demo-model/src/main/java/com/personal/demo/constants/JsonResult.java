package com.personal.demo.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果
 *
 * @author shiweinan
 * @date 2020-07-24 16:24
 */
public class JsonResult {

    private Boolean success;

    private String message;

    private Map<String, Object> data;

    public static JsonResult getInstance() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(false);
        jsonResult.setMessage("");
        int length = 4;
        jsonResult.setData(new HashMap<>(length));
        return jsonResult;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addData(String key, Object value) {
        data.put(key, value);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    /**
     * 新增成功
     */
    public void addSuccess () {
        this.success = true;
        this.message = JsonResult.ADD_SUCCESS;
    }

    /**
     * 新增失败
     */
    public void addFail () {
        this.success = false;
        this.message = JsonResult.ADD_FAIL;
    }

    /**
     * 删除成功
     */
    public void removeSuccess () {
        this.success = true;
        this.message = JsonResult.REMOVE_SUCCESS;
    }

    /**
     * 删除失败
     */
    public void removeFail () {
        this.success = false;
        this.message = JsonResult.REMOVE_FAIL;
    }

    /**
     * 编辑成功
     */
    public void modifySuccess () {
        this.success = true;
        this.message = JsonResult.MODIFY_SUCCESS;
    }

    /**
     * 编辑失败
     */
    public void modifyFail () {
        this.success = false;
        this.message = JsonResult.MODIFY_FAIL;
    }

    /**
     * 查询成功
     */
    public void querySuccess () {
        this.success = true;
        this.message = JsonResult.QUERY_SUCCESS;
    }

    /**
     * 查询失败
     */
    public void queryFail () {
        this.success = false;
        this.message = JsonResult.QUERY_FAIL;
    }

    /**       常量：新增成功       **/
    public static final String ADD_SUCCESS = "新增成功";

    /**       常量：新增失败       **/
    public static final String ADD_FAIL = "新增失败";

    /**       常量：删除成功       **/
    public static final String REMOVE_SUCCESS = "删除成功";

    /**       常量：删除失败       **/
    public static final String REMOVE_FAIL = "删除失败";

    /**       常量：编辑成功       **/
    public static final String MODIFY_SUCCESS = "编辑成功";

    /**       常量：编辑失败       **/
    public static final String MODIFY_FAIL = "编辑失败";

    /**       常量：查询成功       **/
    public static final String QUERY_SUCCESS = "查询成功";

    /**       常量：查询失败       **/
    public static final String QUERY_FAIL = "查询失败";
}
