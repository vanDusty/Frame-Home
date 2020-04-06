package cn.van.spring.copy.beancopier;

import cn.van.spring.copy.beancopier.converter.UserDomainConverter;
import cn.van.spring.copy.beancopier.entity.UserDO;
import cn.van.spring.copy.beancopier.entity.UserDomain;
import cn.van.spring.copy.beancopier.model.UserDTO;
import cn.van.spring.copy.beancopier.util.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @公众号： 风尘博客
 * @Classname BeanCopierTest
 * @Description TODO
 * @Date 2019/11/6 11:21 下午
 * @Author by Van
 */
@Slf4j
public class BeanCopierTest {

    /**
     * 一般拷贝（只拷贝名称和类型都相同的属性）
     */
    @Test
    public void normalCopy() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        // 第一个参数：源对象， 第二个参数：目标对象，第三个参数：是否使用自定义转换器（下面会介绍），下同
        BeanCopier b = BeanCopier.create(UserDO.class, UserDTO.class, false);
        UserDTO userDTO = new UserDTO();
        b.copy(userDO, userDTO, null);
        log.info("拷贝后：userDTO:{}", userDTO);
    }

    /**
     * 类型不同,使用Converter
     */
    @Test
    public void converterTest() {
        // 模拟查询出数据
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        BeanCopier copier = BeanCopier.create(UserDO.class, UserDomain.class, true);
        UserDomainConverter converter = new UserDomainConverter();
        UserDomain userDomain = new UserDomain();
        copier.copy(userDO, userDomain, converter);
        log.info("拷贝后：userDomain:{}", userDomain);
    }

    /**
     * 缓存BeanCopier 实例提升性能
     */
    @Test
    public void beanCopierWithCache() {

        List<UserDO> userDOList = DataUtil.createDataList(10000);
        long start = System.currentTimeMillis();
        List<UserDTO> userDTOS = new ArrayList<>();
        userDOList.forEach(userDO -> {
            UserDTO userDTO = new UserDTO();
            copy(userDO, userDTO);
            userDTOS.add(userDTO);
        });
    }

    /**
     * 缓存 BeanCopier
     */
    private static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIERS = new ConcurrentHashMap<>();

    public void copy(Object srcObj, Object destObj) {
        String key = genKey(srcObj.getClass(), destObj.getClass());
        BeanCopier copier = null;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        copier.copy(srcObj, destObj, null);

    }
    private String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }
}
