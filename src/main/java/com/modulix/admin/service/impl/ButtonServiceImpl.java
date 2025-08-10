package com.modulix.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.modulix.admin.domain.Button;
import com.modulix.admin.dto.ButtonDTO;
import com.modulix.admin.mapper.ButtonMapper;
import com.modulix.admin.query.ButtonQuery;
import com.modulix.admin.service.ButtonService;
import com.modulix.admin.vo.ButtonVO;
import com.modulix.framework.mybatis.plus.api.base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * (Button)表服务实现类
 *
 * @author lipanre
 * @since 2025-08-10 16:07:33
 */
@Service
@RequiredArgsConstructor
public class ButtonServiceImpl extends BaseServiceImpl<ButtonMapper, Button> implements ButtonService {


    @Override
    public Boolean create(ButtonDTO dto) {
        Button domain = converter.convert(dto, Button.class);
        return save(domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeBatch(List<Long> ids) {
        return removeBatchByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(Long id, ButtonDTO dto) {
        Button domain = converter.convert(dto, Button.class);
        domain.setId(id);
        return updateById(domain);
    }

    @Override
    public List<ButtonVO> list(ButtonQuery query) {
        return baseMapper.list(query);
    }

    @Override
    public ButtonVO detail(Long id) {
        return baseMapper.getDetail(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createButton(Long menuId, List<ButtonDTO> dtoList) {
        List<Button> buttons = dtoList.stream().map(dto -> {
            Button button = converter.convert(dto, Button.class);
            button.setMenuId(menuId);
            return button;
        }).toList();
        saveBatch(buttons);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateButtons(Long menuId, List<ButtonDTO> dtoList, List<Long> deleteIds) {
        if (CollUtil.isNotEmpty(deleteIds)) {
            removeBatchByIds(deleteIds);
        }
        if (CollectionUtils.isEmpty(dtoList)) {
            return;
        }
        List<Button> buttons = converter.convert(dtoList, Button.class);
        buttons.forEach(button -> button.setMenuId(menuId));
        saveOrUpdateBatch(buttons);
    }
}
