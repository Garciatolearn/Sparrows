package org.sparrow.common.http;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Result<T>{

    public final static String SUCCESS_CODE = "200";

    private String code;

    private String message;

    private T data;

}
