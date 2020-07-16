package com.personal.demo.dao;

import com.personal.demo.GroupEntity;

import java.util.List;

/**
 * 分组dao层
 *
 * @author oop
 */
public interface GroupDao {

    /**
     * 查询全部分组
     *
     * @return 分组集合
     */
    List<GroupEntity> findAllGroup();
}
