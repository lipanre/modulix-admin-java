package com.modulix.admin.service.impl;

import com.modulix.admin.domain.Dict;
import com.modulix.admin.mapper.DictMapper;
import com.modulix.admin.service.DictService;
import org.springframework.stereotype.Service;
import com.modulix.framework.mybatis.plus.api.base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import com.modulix.admin.vo.DictVO;
import com.modulix.admin.dto.DictDTO;
import com.modulix.admin.query.DictQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 字典(Dict)表服务实现类
 *
 * @author lipanre
 * @since 2025-07-24 01:29:08
 */
@Service
@RequiredArgsConstructor
public class DictServiceImpl extends BaseServiceImpl<DictMapper, Dict> implements DictService {


    @Override
    public Boolean create(DictDTO dto) {
        Dict domain = converter.convert(dto, Dict.class);
        return save(domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean removeBatch(List<Long> ids) {
        return removeBatchByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(Long id, DictDTO dto) {
        Dict domain = converter.convert(dto, Dict.class);
        domain.setId(id);
        return updateById(domain);
    }

    @Override
    public List<DictVO> list(DictQuery query) {
        return baseMapper.list(query);
    }

    @Override
    public DictVO detail(Long id) {
        return baseMapper.getDetail(id);
    }
}
