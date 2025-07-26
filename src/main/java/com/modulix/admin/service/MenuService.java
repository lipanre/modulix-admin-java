package com.modulix.admin.service;

import com.modulix.framework.mybatis.plus.api.base.BaseService;
import com.modulix.admin.domain.Menu;
import com.modulix.admin.vo.MenuVO;
import com.modulix.admin.dto.MenuDTO;
import com.modulix.admin.query.MenuQuery;

import java.util.List;

/**
 * 菜单(Menu)表服务接口
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
public interface MenuService extends BaseService<Menu> {

    /**
     * 创建
     *
     * @param dto dto
     * @return true - 成功  <br>
     * false - 失败
     */
    Boolean create(MenuDTO dto);

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
    Boolean update(Long id, MenuDTO dto);

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    List<MenuVO> list(MenuQuery query);

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    MenuVO detail(Long id);
}
