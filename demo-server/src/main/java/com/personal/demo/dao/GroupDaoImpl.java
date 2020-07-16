package com.personal.demo.dao;

import com.personal.demo.GroupEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author shiweinan
 * @date 2020-07-16 18:12
 */
@Repository
public class GroupDaoImpl implements GroupDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override public List<GroupEntity> findAllGroup() {
        String sql = "SELECT id FROM group_entity";
        return entityManager.createQuery(sql).getResultList();
    }
}
