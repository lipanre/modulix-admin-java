package com.modulix.admin.mapper;

import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.modulix.admin.domain.Dict;
import com.modulix.admin.query.DictQuery;
import com.modulix.admin.vo.DictVO;
import com.modulix.framework.mybatis.plus.api.base.BaseMapper;

import java.util.List;


/**
 * 字典(Dict)表数据库访问层
 *
 * @author lipanre
 * @since 2025-07-24 01:29:08
 */
public interface DictMapper extends BaseMapper<Dict> {

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    default List<DictVO> list(DictQuery query) {
        MPJLambdaWrapper<Dict> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Dict.class);
        wrapper.orderByDesc(Dict::getCreateTime);
        return selectJoinList(DictVO.class, wrapper);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    default DictVO getDetail(Long id) {
        MPJLambdaWrapper<Dict> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Dict.class);
        wrapper.eq(Dict::getId, id);
        return selectJoinOne(DictVO.class, wrapper);
    }
}

