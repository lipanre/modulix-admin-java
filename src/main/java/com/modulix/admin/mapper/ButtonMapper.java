package com.modulix.admin.mapper;

import com.modulix.admin.domain.Button;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.modulix.admin.vo.ButtonVO;
import com.modulix.admin.dto.ButtonDTO;
import com.modulix.admin.query.ButtonQuery;

import java.util.List;

import com.modulix.framework.mybatis.plus.api.base.BaseMapper;


/**
 * (Button)表数据库访问层
 *
 * @author lipanre
 * @since 2025-08-10 16:07:33
 */
public interface ButtonMapper extends BaseMapper<Button> {

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    default List<ButtonVO> list(ButtonQuery query) {
        MPJLambdaWrapper<Button> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Button.class);
        wrapper.orderByDesc(Button::getCreateTime);
        return selectJoinList(ButtonVO.class, wrapper);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    default ButtonVO getDetail(Long id) {
        MPJLambdaWrapper<Button> wrapper = MPJWrappers.lambdaJoin();
        wrapper.selectAll(Button.class);
        wrapper.eq(Button::getId, id);
        return selectJoinOne(ButtonVO.class, wrapper);
    }
}

