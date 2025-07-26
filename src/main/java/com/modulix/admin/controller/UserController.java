package com.modulix.admin.controller;

import com.modulix.admin.service.UserService;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import com.modulix.admin.vo.UserVO;
import com.modulix.admin.dto.UserDTO;
import com.modulix.admin.query.UserQuery;
import com.modulix.framework.web.aip.http.Response;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import com.modulix.framework.mybatis.plus.api.annotation.PageRequest;
import org.springframework.validation.annotation.Validated;
import com.modulix.framework.validation.common.ValidateGroup;

/**
 * 用户(User)表控制层
 *
 * @author lipanre
 * @since 2025-07-26 13:56:16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 创建数据
     *
     * @param dto dto
     * @return true - 成功 <br> false - 失败
     */
    @PostMapping
    public Response<Boolean> create(@RequestBody @Validated(ValidateGroup.Insert.class) UserDTO dto) {
        return Response.success(userService.create(dto));
    }

    /**
     * 删除数据
     *
     * @param ids id列表
     * @return true - 成功 <br> false - 失败
     */
    @DeleteMapping
    public Response<Boolean> remove(@RequestBody @NotEmpty(message = "id列表不能为空") List<Long> ids) {
        return Response.success(userService.removeBatch(ids));
    }

    /**
     * 更新指定数据
     *
     * @param id  数据id
     * @param dto 数据dto
     * @return true - 成功 <br> false - 失败
     */
    @PutMapping("/{id}")
    public Response<Boolean> update(@PathVariable Long id, @RequestBody @Validated({ValidateGroup.Update.class}) UserDTO dto) {
        return Response.success(userService.update(id, dto));
    }

    /**
     * 查询列表
     *
     * @return 列表
     */
    @PageRequest
    @GetMapping
    public Response<List<UserVO>> list(UserQuery query) {
        return Response.success(userService.list(query));
    }

    /**
     * 查询详情
     *
     * @param id 数据id
     * @return 数据详情
     */
    @GetMapping("/{id}")
    public Response<UserVO> detail(@PathVariable Long id) {
        return Response.success(userService.detail(id));
    }

}

