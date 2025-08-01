package com.modulix.admin.mapper;

import com.modulix.admin.domain.Dept;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.modulix.admin.vo.DeptVO;
import com.modulix.admin.dto.DeptDTO;
import com.modulix.admin.query.DeptQuery;

import java.util.List;

import com.modulix.framework.mybatis.plus.api.base.BaseMapper;


/**
 * (Dept)表数据库访问层
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
public interface DeptMapper extends BaseMapper<Dept> {

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    default List<DeptVO> list(DeptQuery query) {
        MPJLambdaWrapper<Dept> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Dept.class);
        wrapper.orderByDesc(Dept::getCreateTime);
        return selectJoinList(DeptVO.class, wrapper);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    default DeptVO getDetail(Long id) {
        MPJLambdaWrapper<Dept> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Dept.class);
        wrapper.eq(Dept::getId, id);
        return selectJoinOne(DeptVO.class, wrapper);
    }
}

