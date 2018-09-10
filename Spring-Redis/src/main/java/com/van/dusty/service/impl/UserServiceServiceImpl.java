package com.van.dusty.service.impl;

import com.alibaba.fastjson.JSON;
import com.van.dusty.common.enums.ResultCode;
import com.van.dusty.common.result.ApiResult;
import com.van.dusty.common.result.ResultUtils;
import com.van.dusty.common.utils.StringUtils;
import com.van.dusty.dao.UserDAO;
import com.van.dusty.enums.ProjectNameEnum;
import com.van.dusty.enums.SendSmsTypeEnum;
import com.van.dusty.model.UserDO;
import com.van.dusty.redis.MemberConstants;
import com.van.dusty.redis.StringCache;
import com.van.dusty.service.UserService;
import com.van.dusty.service.entity.SendSmsCodeVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-04 14:39
 **/
@Service
public class UserServiceServiceImpl implements UserService {

    @Resource
    StringCache stringCache;

//    private static final Logger logger = Logger.getLogger(UserServiceServiceImpl.class);

    @Resource
    private UserDAO userDAO;//这里会报错，但是并不会影响


    @Override
    public ApiResult userLogin(UserDO userDO) {
        UserDO user = userDAO.selectUserByUserName(userDO.getUserName());
        if (null == user) {
            return ResultUtils.setError(ResultCode.LACK_PARAM_ERROR);
        }
        if (!user.getPassword().equals(userDO.getPassword())) {
            return ResultUtils.setError(ResultCode.SYSTEM_ERROR);
        }
        return ResultUtils.setOk(user);
    }

    public ApiResult sendSmsVerifyCode(SendSmsCodeVO sendSmsCodeVO) {
        SendSmsCodeVO.SendSmsCodeParams param = sendSmsCodeVO.getParam();
        ProjectNameEnum projectNameEnum = getValidProjectNameEnum(sendSmsCodeVO.getProjectName());
        SendSmsTypeEnum sendSmsTypeEnum = SendSmsTypeEnum.checkSendType(param.getType());
        // 参数校验
        if (projectNameEnum == null || sendSmsTypeEnum == null) {
            return ResultUtils.setError(ResultCode.LACK_PARAM_ERROR);
        }
        param.setZoneNum(param.getZoneNum() == null ? 86 : param.getZoneNum());
        if (StringUtils.isEmpty(sendSmsCodeVO.getParam().getPhone())) {
            return ResultUtils.setError(ResultCode.LACK_PARAM_ERROR);
        }

        //根据类型判断用户是否还可以继续发送短信
        checkSendTypeDetail(sendSmsTypeEnum,param.getPhone(),param.getZoneNum());
        //判断发送验证码是否超过限定次数
        String redisKey = getVerifyCodeCacheKeySuffix(projectNameEnum.getProjectName(),param.getType(), param.getZoneNum(), param.getPhone());
        String sendCount = stringCache.get(MemberConstants.VERIFY_CODE_FOR_SEND_TIMES + redisKey);
        if(StringUtils.isNotBlank(sendCount) && Integer.parseInt(sendCount) > MemberConstants.MAX_SEND_COUNT){
            return ResultUtils.setError(ResultCode.SEND_PHONE_EXCEPTION);
        }
        //查看是否发过短信 且 是否还有效
        String cacheVerifyCodeTime = stringCache.get(MemberConstants.VERIFY_CODE_FOR_FREQUENT_ONE_MINUTE + redisKey);
        if(StringUtils.isNotBlank(cacheVerifyCodeTime)){
            int sendTime= (int) ((System.currentTimeMillis() - Long.parseLong(cacheVerifyCodeTime))/ 1000);
            if( sendTime < MemberConstants.ONE_MINUTES){
                return ResultUtils.setError(null,ResultCode.SEND_REPEAT_REQUEST,String.valueOf(MemberConstants.ONE_MINUTES - sendTime));
            }
        }
        // 生成随机的六位验证码
        String identifyingCode = String.valueOf((int)((Math.random()*9+1)*100000));
        // 发送验证码：省略
        //假设发送成功，把验证码存入缓存
        stringCache.put(MemberConstants.VERIFY_CODE_FOR_BY_PHONE ,identifyingCode,MemberConstants.FIFTEEN_MINUTES);
        //存放当前时间，用于判断60秒内不可重复发送验证码
        stringCache.put(MemberConstants.VERIFY_CODE_FOR_FREQUENT_ONE_MINUTE + redisKey,String.valueOf(System.currentTimeMillis()),MemberConstants.ONE_MINUTES);
        int sendCounts = StringUtils.isNotBlank(sendCount)?Integer.parseInt(sendCount) + 1 : 1;
        stringCache.put(MemberConstants.VERIFY_CODE_FOR_SEND_TIMES + redisKey,sendCounts+"",currentDaysurplusTime());
        return ResultUtils.setOk(identifyingCode);
    }
    //当天剩余时间,单位：秒
    public static int currentDaysurplusTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long CurrentdayEnd = calendar.getTimeInMillis();
        long currentTime = System.currentTimeMillis();
        int surplusTime = (int) ((CurrentdayEnd - currentTime)/1000);
        return surplusTime;
    }

    private String getVerifyCodeCacheKeySuffix(String projectName, String type, Integer zoneNum, String phone) {
       return MemberConstants.putRediskey(projectName, type, zoneNum, phone);
    }

    private void checkSendTypeDetail(SendSmsTypeEnum sendSmsTypeEnum, String phone, Integer zoneNum) {
        switch (sendSmsTypeEnum){
            case FIND:
                //Long userId = userService.checkLoginNameExists(phone, RegisterTypeEnum.MOBILE, zoneNum);
                //if(userId == null){
                  //  throw new ProductException(ResultCode.USER_NOT_EXIST.name());
                //}
                break;
            case REGISTER:
                //Long userIdReg = userService.checkLoginNameExists(phone, RegisterTypeEnum.MOBILE, zoneNum);
                //if(userIdReg != null){
                  //  throw new ProductException(ResultCode.MOBILE_REGISTERED.name());
                //}
                break;
        }
    }

    private ProjectNameEnum getValidProjectNameEnum(String appName){
        ProjectNameEnum projectNameEnum = ProjectNameEnum.getEnumByProjectName(appName);
        if(projectNameEnum == null){
            return null;
        }
        return projectNameEnum;
    }
    // 校验项目名称
    public ApiResult userRegister(UserDO userDO) {
//        logger.info("checkSmsVerifyCode param ：" + JSON.toJSONString(userDO));
//        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(verifyCode)) {
//            return ResultUtils.setError(ResultCode.LACK_PARAM_ERROR);
//        }
//        //获取缓存的验证码
//        String identifyingCodeCache = stringCache.get(MemberConstants.VERIFY_CODE_FOR_BY_PHONE);
//        if (identifyingCodeCache.equals(verifyCode)) {
//            return ResultUtils.setOk();
//        }
        return ResultUtils.setError(ResultCode.PARAMS_ERROR);
    }
}
