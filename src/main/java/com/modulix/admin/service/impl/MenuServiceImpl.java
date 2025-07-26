package com.modulix.admin.service.impl;

import com.modulix.admin.domain.Menu;
import com.modulix.admin.mapper.MenuMapper;
import com.modulix.admin.service.MenuService;
import org.springframework.stereotype.Service;
import com.modulix.framework.mybatis.plus.api.base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import com.modulix.admin.vo.MenuVO;
import com.modulix.admin.dto.MenuDTO;
import com.modulix.admin.query.MenuQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 菜单(Menu)表服务实现类
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends BaseServiceImpl<MenuMapper, Menu> implements MenuService {


    @Override
    public Boolean create(MenuDTO dto) {
        Menu domain = converter.convert(dto, Menu.class);
        return save(domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeBatch(List<Long> ids) {
        return removeBatchByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(Long id, MenuDTO dto) {
        Menu domain = converter.convert(dto, Menu.class);
        domain.setId(id);
        return updateById(domain);
    }

    @Override
    public List<MenuVO> list(MenuQuery query) {
        return baseMapper.list(query);
    }

    @Override
    public MenuVO detail(Long id) {
        return baseMapper.getDetail(id);
    }
}
