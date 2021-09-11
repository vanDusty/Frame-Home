package cn.van.mybatis.batch;

import cn.van.mybatis.batch.entity.UserInfoBatchDO;
import cn.van.mybatis.batch.mapper.UserInfoBatchMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StopWatch;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MybatisBatchInsertTest extends BaseTest {

    @Resource
    UserInfoBatchMapper userInfoBatchMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    private List<UserInfoBatchDO> list = new ArrayList<>();
    private List<UserInfoBatchDO> lageList = new ArrayList<>();
    private List<UserInfoBatchDO> lessList = new ArrayList<>();
    private List<UserInfoBatchDO> warmList = new ArrayList<>();
    // 计数工具
    private StopWatch sw = new StopWatch();

    @Before
    public void assemblyData() {
        lageList = assemblyData(1000000);
        list = assemblyData(200000);
        lessList = assemblyData(2000);
        warmList = assemblyData(5);
    }

    private List<UserInfoBatchDO> assemblyData(int count){
        List<UserInfoBatchDO> list = new ArrayList<>();
        UserInfoBatchDO userInfoDO;
        for (int i = 0;i < count;i++){
            userInfoDO = new UserInfoBatchDO()
                    .setUserName("Van")
                    .setNickName("123456")
                    .setNickName("风尘博客")
                    .setMobile("17098705205")
                    .setPassWord("password")
                    .setGmtUpdate(LocalDateTime.now());
            list.add(userInfoDO);
        }
        return list;
    }

    /**
     * 反复执行单条插入语句
     */
    @Test
    public void insert() {
        log.info("【程序热身】");
        for (UserInfoBatchDO userInfoBatchDO : warmList) {
            userInfoBatchMapper.insert(userInfoBatchDO);
        }
        log.info("【热身结束】");
        sw.start("反复执行单条插入语句");
        // 这里插入 20w 条太慢了，所以我只插入了 2000 条
        for (UserInfoBatchDO userInfoBatchDO : lessList) {
            userInfoBatchMapper.insert(userInfoBatchDO);
        }
        sw.stop();
        log.info("all cost info:{}",sw.prettyPrint());
    }

    /**
     * foreach 拼接 sql
     */
    @Test
    public void batchInsert() {
        log.info("【程序热身】");
        for (UserInfoBatchDO userInfoBatchDO : warmList) {
            userInfoBatchMapper.insert(userInfoBatchDO);
        }
        log.info("【热身结束】");
        sw.start("foreach 拼接 sql");
        userInfoBatchMapper.batchInsert(list);
        sw.stop();
        log.info("all cost info:{}",sw.prettyPrint());
    }


    /**
     * 批处理 - ExecutorType
     */
    @Test
    public void processInsert() {
        log.info("【程序热身】");
        for (UserInfoBatchDO userInfoBatchDO : warmList) {
            userInfoBatchMapper.insert(userInfoBatchDO);
        }
        log.info("【热身结束】");
        sw.start("批处理执行 插入");
        // 打开批处理
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH);
        UserInfoBatchMapper mapper = session.getMapper(UserInfoBatchMapper.class);
        for (int i = 0,length = list.size(); i < length; i++) {
            mapper.insert(list.get(i));
            //每20000条提交一次防止内存溢出
            if(i%20000==19999){
                session.commit();
                session.clearCache();
            }
        }
        session.commit();
        session.clearCache();
        sw.stop();
        log.info("all cost info:{}",sw.prettyPrint());
    }
}