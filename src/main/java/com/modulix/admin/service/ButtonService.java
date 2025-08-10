package com.modulix.admin.service;

import com.modulix.framework.mybatis.plus.api.base.BaseService;
import com.modulix.admin.domain.Button;
import com.modulix.admin.vo.ButtonVO;
import com.modulix.admin.dto.ButtonDTO;
import com.modulix.admin.query.ButtonQuery;

import java.util.List;

/**
 * (Button)表服务接口
 *
 * @author lipanre
 * @since 2025-08-10 16:07:33
 */
public interface ButtonService extends BaseService<Button> {

    /**
     * 创建
     *
     * @param dto dto
     * @return true - 成功  <br>
     * false - 失败
     */
    Boolean create(ButtonDTO dto);

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
    Boolean update(Long id, ButtonDTO dto);

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    List<ButtonVO> list(ButtonQuery query);

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    ButtonVO detail(Long id);

    /**
     * 创建按钮
     *
     * @param menuId 菜单id
     * @param dtoList 按钮列表
     */
    void createButton(Long menuId, List<ButtonDTO> dtoList);

    /**
     * 更新按钮
     *
     * @param dtoList    按钮列表
     * @param menuId    菜单id
     * @param deleteIds 按钮列表
     */
    void updateButtons(Long menuId, List<ButtonDTO> dtoList, List<Long> deleteIds);
}
