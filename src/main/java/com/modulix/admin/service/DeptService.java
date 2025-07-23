package com.modulix.admin.service;

import com.modulix.framework.mybatis.plus.api.base.BaseService;
import com.modulix.admin.domain.Dept;
import com.modulix.admin.vo.DeptVO;
import com.modulix.admin.dto.DeptDTO;
import com.modulix.admin.query.DeptQuery;

import java.util.List;

/**
 * (Dept)表服务接口
 *
 * @author lipanre
 * @since 2025-07-24 01:29:08
 */
public interface DeptService extends BaseService<Dept> {

    /**
     * 创建
     *
     * @param dto dto
     * @return true - 成功  <br>
     * false - 失败
     */
    Boolean create(DeptDTO dto);

    /**
     * 删除
     *
     * @param ids id列表
     * @return true - 成功 <br> false - 失败
     */
    Boolean removeBatch(List<Long> ids);

    /**
     * 更新
     *
     * @param id  id
     * @param dto dto
     * @return true - 成功 <br> false - 失败
     */
    Boolean update(Long id, DeptDTO dto);

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    List<DeptVO> list(DeptQuery query);

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    DeptVO detail(Long id);
}
