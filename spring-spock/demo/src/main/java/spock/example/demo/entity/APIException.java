/*
 * @Author: 丑牛
 * @Date: 2021-10-11 19:42:05
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-15 13:41:53
 * @Description: 自定义业务异常
 */
package spock.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class APIException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public APIException(String errcode, String errorMessage){
        super();
        this.errorCode = errcode;
        this.errorMessage = errorMessage;
    }
}
