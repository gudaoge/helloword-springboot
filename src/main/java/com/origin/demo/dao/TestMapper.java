package com.origin.demo.dao;

import com.origin.demo.model.domain.TestDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by dengqingling on 2019-07-03
 */
@Mapper
public interface TestMapper {

    TestDO getById(Long id);

    List<TestDO> getList();

    int insert(TestDO testDO);

    int update(TestDO testDO);

    int delete(Long id);
}
