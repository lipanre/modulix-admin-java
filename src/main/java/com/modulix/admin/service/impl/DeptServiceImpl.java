package com.modulix.admin.service.impl;

import com.modulix.admin.domain.Dept;
import com.modulix.admin.mapper.DeptMapper;
import com.modulix.admin.service.DeptService;
import com.modulix.framework.common.core.util.TreeUtil;
import com.modulix.framework.mybatis.plus.api.annotation.DeleteOperation;
import org.springframework.stereotype.Service;
import com.modulix.framework.mybatis.plus.api.base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import com.modulix.admin.vo.DeptVO;
import com.modulix.admin.dto.DeptDTO;
import com.modulix.admin.query.DeptQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * (Dept)表服务实现类
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
@Service
@RequiredArgsConstructor
public class DeptServiceImpl extends BaseServiceImpl<DeptMapper, Dept> implements DeptService {


    @Override
    public Boolean create(DeptDTO dto) {
        Dept domain = converter.convert(dto, Dept.class);
        return save(domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DeleteOperation(value = Dept.class, condition = "parent_id in #{#ids}")
    public Boolean removeBatch(List<Long> ids) {
        return removeBatchByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(Long id, DeptDTO dto) {
        Dept domain = converter.convert(dto, Dept.class);
        domain.setId(id);
        return updateById(domain);
    }

    @Override
    public List<DeptVO> list(DeptQuery query) {
        return baseMapper.list(query);
    }

    @Override
    public DeptVO detail(Long id) {
        return baseMapper.getDetail(id);
    }

    @Override
    public List<DeptVO> tree() {
        List<Dept> deptList = list();
        List<DeptVO> deptVOList = converter.convert(deptList, DeptVO.class);
        return TreeUtil.buildTree(deptVOList, Objects::isNull);
    }
}
