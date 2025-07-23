package com.modulix.admin.service;

import com.modulix.framework.mybatis.plus.api.base.BaseService;
import com.modulix.admin.domain.Dict;
import com.modulix.admin.vo.DictVO;
import com.modulix.admin.dto.DictDTO;
import com.modulix.admin.query.DictQuery;

import java.util.List;

/**
 * 字典(Dict)表服务接口
 *
 * @author lipanre
 * @since 2025-07-24 01:29:08
 */
public interface DictService extends BaseService<Dict> {

    /**
     * 创建
     *
     * @param dto dto
     * @return true - 成功  <br>
     * false - 失败
     */
    Boolean create(DictDTO dto);

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
    Boolean update(Long id, DictDTO dto);

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    List<DictVO> list(DictQuery query);

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    DictVO detail(Long id);
}
