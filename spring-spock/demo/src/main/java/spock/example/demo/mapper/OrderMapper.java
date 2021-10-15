
/*
 * @Author: 丑牛
 * @Date: 2021-10-11 20:01:44
 * @LastEditors: 丑牛
 * @LastEditTime: 2021-10-11 20:28:15
 * @Description: file content
 */
package spock.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import spock.example.demo.entity.OrderDTO;
import spock.example.demo.entity.OrderVO;

@Mapper
public interface OrderMapper {
    
    static final OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mappings({})
    OrderVO convert(OrderDTO requseDto);
    
}
