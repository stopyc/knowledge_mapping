package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: knowledge_mapping
 * @description:
 * @author: stop.yc
 * @create: 2022-08-17 21:06
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class NodeVo {

    private String id;

    private String label;

    private int type;
}
