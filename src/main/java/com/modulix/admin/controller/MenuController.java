package com.modulix.admin.controller;

import com.modulix.admin.dto.MenuDTO;
import com.modulix.admin.query.MenuQuery;
import com.modulix.admin.service.MenuService;
import com.modulix.admin.vo.MenuButtonVO;
import com.modulix.admin.vo.MenuVO;
import com.modulix.framework.mybatis.plus.api.annotation.PageRequest;
import com.modulix.framework.validation.common.ValidateGroup;
import com.modulix.framework.web.aip.http.Response;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * 菜单(Menu)表控制层
 *
 * @author lipanre
 * @since 2025-07-28 22:51:56
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
     * 删除指定id的菜单
     *
     * @param id 菜单id
     */
    @DeleteMapping("/{id}")
    public Response<Boolean> remove(@PathVariable Long id) {
        return Response.success(menuService.removeBatch(Collections.singletonList(id)));
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
    @GetMapping("/tree")
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

    /**
     * 页面列表
     *
     * @return 页面列表
     */
    @GetMapping("/all-page")
    public Response<List<String>> getAllPage() {
        return Response.success(menuService.listAllPage());
    }

    /**
     * 查询菜单按钮列表
     *
     * @return 菜单按钮列表
     */
    @GetMapping("/page-buttons")
    public Response<List<MenuButtonVO>> listMenuButtons() {
        return Response.success(menuService.listMenuButtons());
    }
}

