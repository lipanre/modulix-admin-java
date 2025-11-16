package com.modulix.admin.controller;

import com.modulix.admin.dto.DeptDTO;
import com.modulix.admin.query.DeptQuery;
import com.modulix.admin.service.DeptService;
import com.modulix.admin.vo.DeptVO;
import com.modulix.framework.mybatis.plus.api.annotation.PageRequest;
import com.modulix.framework.validation.common.ValidateGroup;
import com.modulix.framework.web.api.http.Response;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Dept)表控制层
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 创建数据
     *
     * @param dto dto
     * @return true - 成功 <br> false - 失败
     */
    @PostMapping
    public Response<Boolean> create(@RequestBody @Validated(ValidateGroup.Insert.class) DeptDTO dto) {
        return Response.success(deptService.create(dto));
    }

    /**
     * 删除数据
     *
     * @param ids id列表
     * @return true - 成功 <br> false - 失败
     */
    @DeleteMapping
    public Response<Boolean> remove(@RequestBody @NotEmpty(message = "id列表不能为空") List<Long> ids) {
        return Response.success(deptService.removeBatch(ids));
    }

    /**
     * 更新指定数据
     *
     * @param id  数据id
     * @param dto 数据dto
     * @return true - 成功 <br> false - 失败
     */
    @PutMapping("/{id}")
    public Response<Boolean> update(@PathVariable Long id, @RequestBody @Validated({ValidateGroup.Update.class}) DeptDTO dto) {
        return Response.success(deptService.update(id, dto));
    }

    /**
     * 查询列表
     *
     * @return 列表
     */
    @PageRequest
    @GetMapping
    public Response<List<DeptVO>> list(DeptQuery query) {
        return Response.success(deptService.list(query));
    }

    /**
     * 查询详情
     *
     * @param id 数据id
     * @return 数据详情
     */
    @GetMapping("/{id}")
    public Response<DeptVO> detail(@PathVariable Long id) {
        return Response.success(deptService.detail(id));
    }

    /**
     * 部门树
     *
     */
    @GetMapping("/tree")
    public Response<List<DeptVO>> tree() {
       return Response.success(deptService.tree());
    }
}

