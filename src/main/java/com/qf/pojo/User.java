package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 被覆盖
@Data

// 代表生成全部的有参构造
@AllArgsConstructor
// 代表生成无参构造
@NoArgsConstructor
public class User {

    private int id;

    private String userName;

    private String passWord;

    private Date birth;
}
