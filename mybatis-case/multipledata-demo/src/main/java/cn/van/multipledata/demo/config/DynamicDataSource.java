package cn.van.multipledata.demo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * @公众号： 风尘博客
 * @Classname DataSourceContextHolder
 * @Description 继承 AbstractRoutingDataSource 重写 determineCurrentLookupKey()，动态实现根据请求不同达到切换数据源的需求。
 * @Date 2019/4/14 3:59 下午
 * @Author by Van
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 获取路由
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        // 根据MyThreadLocal.getLocal()判断该次请求使用的是哪个数据源
        return DataSourceContextHolder.get();
    }

}
