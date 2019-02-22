package com.yuanyk.springbootmybatis.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

//@MappedJdbcTypes(JdbcType.VARCHAR)
//添加此注解 TypeHandler适用于所有的varchar字段
//不添加此注解，需要在mapper.xml 的查询或插入语句中单独设置TypeHandler
public class MyTypeHandler extends BaseTypeHandler<String> {
    public MyTypeHandler() {
    }

    /**
     * 插入数据库时对String做映射
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, "insert "+parameter);
    }

    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String sqlString = rs.getString(columnName);
        return sqlString != null ? sqlString+" select" : null;
    }

    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String sqlString = rs.getString(columnIndex);
        return sqlString != null ? sqlString+" select" : null;
    }

    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String sqlString = cs.getString(columnIndex);
        return sqlString != null ? sqlString+" select" : null;
    }
}
