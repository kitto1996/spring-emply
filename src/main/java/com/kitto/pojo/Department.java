package com.kitto.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kitto
 * @create 2022-04-07-18:46
 */
@Data
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无参构造器
public class Department {
    private Integer id;
    private String partName;
}
