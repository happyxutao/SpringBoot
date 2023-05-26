package cn.login.common;

import lombok.Data;
import lombok.ToString;
@ToString
@Data
public class Result<T> {
    private String message;
    private String code;
    private T data;
}