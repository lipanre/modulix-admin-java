package com.modulix.admin.controller;

import com.modulix.admin.dto.DictDTO;
import com.modulix.admin.dto.DictDetailDTO;
import com.modulix.admin.query.DictQuery;
import com.modulix.admin.service.DictService;
import com.modulix.admin.vo.DictVO;
import com.modulix.framework.mybatis.plus.api.annotation.PageRequest;
import com.modulix.framework.validation.common.ValidateGroup;
import com.modulix.framework.web.aip.http.Response;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典(Dict)表控制层
 *
 * @author lipanre
 * @since 2025-07-26 13:56:15
 */
@RestController
@RequestMapping("/dict")
public class DictController {

    @Resource
    private DictService dictService;

    /**
     * 创建数据
     *
     * @param dto dto
     * @return true - 成功 <br> false - 失败
     */
    @PostMapping
    public Response<Boolean> create(@RequestBody @Validated(ValidateGroup.Insert.class) DictDTO dto) {
        return Response.success(dictService.create(dto));
    }

    /**
     * 添加字典明细
     *
     * @param dtoList 字典明细列表
     * @return 操作结果
     */
    @PostMapping("/detail")
    public Response<Boolean> upsetDetails(@RequestBody DictDetailDTO dto) {
        return Response.success(dictService.upsetDetails(dto));
    }

    /**
     * 删除数据
     *
     * @param ids id列表
     * @return true - 成功 <br> false - 失败
     */
    @DeleteMapping
    public Response<Boolean> remove(@RequestBody @NotEmpty(message = "id列表不能为空") List<Long> ids) {
        return Response.success(dictService.removeBatch(ids));
    }

    /**
     * 更新指定数据
     *
     * @param id  数据id
     * @param dto 数据dto
     * @return true - 成功 <br> false - 失败
     */
    @PutMapping("/{id}")
    public Response<Boolean> update(@PathVariable Long id, @RequestBody @Validated({ValidateGroup.Update.class}) DictDTO dto) {
        return Response.success(dictService.update(id, dto));
    }

    /**
     * 查询列表
     *
     * @return 列表
     */
    @PageRequest
    @GetMapping
    public Response<List<DictVO>> list(DictQuery query) {
        return Response.success(dictService.list(query));
    }

    /**
     * 查询详情
     *
     * @param id 数据id
     * @return 数据详情
     */
    @GetMapping("/{id}")
    public Response<DictVO> detail(@PathVariable Long id) {
        return Response.success(dictService.detail(id));
    }

    /**
     * 查询所有字典
     *
     * @return 字典列表
     */
    @GetMapping("/all")
    public Response<List<DictVO>> all() {
        return Response.success(dictService.all());
    }

}

