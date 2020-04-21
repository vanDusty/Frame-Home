package cn.van.spring.copy.orika;

import cn.van.spring.copy.orika.entity.UserDO;
import cn.van.spring.copy.orika.entity.UserDomain;
import cn.van.spring.copy.orika.model.UserDTO;
import cn.van.spring.copy.orika.util.DataUtil;
import cn.van.spring.copy.orika.util.MapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @公众号： 风尘博客
 * @Classname OrikaTest
 * @Description
 * @Date 2019/11/6 11:21 下午
 * @Author by Van
 */
@Slf4j
public class OrikaTest {

    /**
     * 一般拷贝（拷贝名称相同类型可不同的属性）
     */
    @Test
    public void normalCopy() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        // 第一个参数：源对象， 第二个参数：目标对象，第三个参数：是否使用自定义转换器（下面会介绍），下同
        UserDTO userDTO = MapperUtils.INSTANCE.map(UserDTO.class, userDO);;
        log.info("拷贝后：userDTO:{}", userDTO);
    }

    /**
     * 字段名称不同，带翻译
     */
    @Test
    public void converterTest() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        Map<String, String> config = new HashMap<>();
        // 自定义配置(balance 转 balances)
        config.put("balance", "balances");
        log.info("拷贝前：userDO:{}", userDO);
        UserDomain userDomain = MapperUtils.INSTANCE.map(UserDomain.class, userDO, config);
        log.info("拷贝后：userDomain:{}", userDomain);
    }

    /**
     * 拷贝集合
     */
    @Test
    public void beanCopierWithCache() {
        List<UserDO> userDOList = DataUtil.createDataList(3);
        log.info("拷贝前：userDOList:{}", userDOList);
        List<UserDTO> userDTOS = MapperUtils.INSTANCE.mapAsList(UserDTO.class,userDOList);
        log.info("拷贝后：userDTOS:{}", userDTOS);
    }

}
