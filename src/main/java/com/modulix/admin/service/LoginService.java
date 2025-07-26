package com.modulix.admin.service;

import com.modulix.framework.mybatis.plus.api.base.BaseService;
import com.modulix.admin.domain.Login;
import com.modulix.admin.vo.LoginVO;
import com.modulix.admin.dto.LoginDTO;
import com.modulix.admin.query.LoginQuery;

import java.util.List;

/**
 * 登录记录(Login)表服务接口
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
public interface LoginService extends BaseService<Login> {

    /**
     * 创建
     *
     * @param dto dto
     * @return true - 成功  <br>
     * false - 失败
     */
    Boolean create(LoginDTO dto);

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
    Boolean update(Long id, LoginDTO dto);

    /**
     * 查询符合条件的列表
     *
     * @param query 查询条件
     * @return 列表
     */
    List<LoginVO> list(LoginQuery query);

    /**
     * 查询详情
     *
     * @param id id
     * @return 详情
     */
    LoginVO detail(Long id);
}
