package cn.van.mybatis.demo.typehandler;

import cn.van.mybatis.demo.util.AesUtil;
import cn.van.mybatis.demo.entity.Encrypt;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Copyright (C), 2015-2022, 风尘博客
 * 公众号 : 风尘博客
 * @Author:   Van
 * Date:     2022/1/6 11:49 下午
 * Description: 加解密的 TypeHandler 类型处理器
 * Version： V1.0
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(Encrypt.class)
public class EncryptTypeHandler extends BaseTypeHandler<Encrypt> {

    public static final String SECRET_KEY= "fdj!s#la$krdF3DG";

    /**
     * 设置参数，加密数据
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Encrypt parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null || parameter.getValue() == null) {
            ps.setString(i, null);
            return;
        }
        String encrypt = AesUtil.Encrypt(parameter.getValue(),SECRET_KEY);
        ps.setString(i, encrypt);
    }

    /**
     * 获取值，解密数据。
     */
    @Override
    public Encrypt getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return decrypt(rs.getString(columnName));
    }

    /**
     * 获取值，解密数据。
     */
    @Override
    public Encrypt getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return decrypt(rs.getString(columnIndex));
    }

    /**
     * 获取值，解密数据。
     */
    @Override
    public Encrypt getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return decrypt(cs.getString(columnIndex));
    }

    public Encrypt decrypt(String value) {
        if (null == value) {
            return null;
        }
        return new Encrypt(AesUtil.Decrypt(value,SECRET_KEY));
    }
}