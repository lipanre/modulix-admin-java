package com.modulix.admin.dto;

import lombok.Data;

import java.util.List;

/**
 * 字典明细DTO
 *
 * @author lipanre
 */
@Data
public class DictDetailDTO {

    /**
     * 删除的字典明细列表
     */
    private List<Long> removeIds;

    /**
     * 待更新或新增的字典明细列表
     */
    private List<DictDTO> details;

}
