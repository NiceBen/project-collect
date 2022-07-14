//package com.niceben.projectmpa.config.mybatis;
//
//import mybatis.mate.encrypt.AES;
//import org.apache.ibatis.type.BaseTypeHandler;
//import org.apache.ibatis.type.JdbcType;
//
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//// AES 是工具方法类，按加密需求设置
//public class AESEncryptHandler extends BaseTypeHandler {
//
//    @Override
//    public void setNonNullParameter(PreparedStatement ps, int columnIndex, Object parameter, JdbcType jdbcType) throws SQLException {
//        try {
//            ps.setString(columnIndex, AES.encrypt("KEY", (String) parameter));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
//        String columnValue = rs.getString(columnName);
//        try {
//            return AES.decrypt("KEY", columnValue);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
//        String columnValue = rs.getString(columnIndex);
//        try {
//            return AES.decrypt("KEY", columnValue);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
//        String columnValue = cs.getString(columnIndex);
//        try {
//            return AES.decrypt("KEY", columnValue);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
