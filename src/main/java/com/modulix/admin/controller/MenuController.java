package com.modulix.admin.controller;

import com.modulix.admin.service.MenuService;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import com.modulix.admin.vo.MenuVO;
import com.modulix.admin.dto.MenuDTO;
import com.modulix.admin.query.MenuQuery;
import com.modulix.framework.web.aip.http.Response;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import com.modulix.framework.mybatis.plus.api.annotation.PageRequest;
import org.springframework.validation.annotation.Validated;
import com.modulix.framework.validation.common.ValidateGroup;

/**
 * 菜单(Menu)表控制层
 *
 * @author lipanre
 * @since 2025-07-24 01:32:39
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 创建数据
     *
     * @param dto dto
     * @return true - 成功 <br> false - 失败
     */
    @PostMapping
    public Response<Boolean> create(@RequestBody @Validated(ValidateGroup.Insert.class) MenuDTO dto) {
        return Response.success(menuService.create(dto));
    }

    /**
     * 删除数据
     *
     * @param ids id列表
     * @return true - 成功 <br> false - 失败
     */
    @DeleteMapping
    public Response<Boolean> remove(@RequestBody @NotEmpty(message = "id列表不能为空") List<Long> ids) {
        return Response.success(menuService.removeBatch(ids));
    }

    /**
     * 更新指定数据
     *
     * @param id  数据id
     * @param dto 数据dto
     * @return true - 成功 <br> false - 失败
     */
    @PutMapping("/{id}")
    public Response<Boolean> update(@PathVariable Long id, @RequestBody @Validated({ValidateGroup.Update.class}) MenuDTO dto) {
        return Response.success(menuService.update(id, dto));
    }

    /**
     * 查询列表
     *
     * @return 列表
     */
    @PageRequest
    @GetMapping
    public Response<List<MenuVO>> list(MenuQuery query) {
        return Response.success(menuService.list(query));
    }

    /**
     * 查询详情
     *
     * @param id 数据id
     * @return 数据详情
     */
    @GetMapping("/{id}")
    public Response<MenuVO> detail(@PathVariable Long id) {
        return Response.success(menuService.detail(id));
    }

}

