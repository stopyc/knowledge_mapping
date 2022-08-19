package com.example.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @program: knowledge_mapping
 * @description:
 * @author: stop.yc
 * @create: 2022-08-15 10:00
 **/

@Data
@ToString
public class RelationVo {

    private String source;

    private String label;

    private String target;
}
