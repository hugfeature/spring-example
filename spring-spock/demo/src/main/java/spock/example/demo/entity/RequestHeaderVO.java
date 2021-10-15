
/*
 * @Author: 丑牛
 * @Date: 2021-10-11 19:48:29
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-11 20:01:19
 * @Description: file content
 */
package spock.example.demo.entity;

import lombok.Data;

@Data
public class RequestHeaderVO {
    String source;
    String version;
    String currency;
    String uid;
    String ip;
    String deviceId;
    String token;
}
