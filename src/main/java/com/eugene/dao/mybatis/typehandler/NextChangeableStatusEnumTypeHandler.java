package com.eugene.dao.mybatis.typehandler;


import com.eugene.Enum.OrderStatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 该TypeHandler仅用作于将表中以字符串隔开的value转成泛型为枚举的list
 */
public class NextChangeableStatusEnumTypeHandler extends BaseTypeHandler<List<OrderStatusEnum>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<OrderStatusEnum> parameter, JdbcType jdbcType) throws SQLException {
        // Do nothing
    }

    @Override
    public List<OrderStatusEnum> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        List<OrderStatusEnum> list = null;
        String value = rs.getString(columnName);

        if (value == null || value.trim().length() == 0) {
            return new ArrayList<>(0);
        }

        list = new ArrayList<>();
        for (String str : value.split(",")) {
            list.add(OrderStatusEnum.valueOf(Integer.valueOf(str.trim())));
        }
        return list;
    }

    @Override
    public List<OrderStatusEnum> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        List<OrderStatusEnum> list = null;
        String value = rs.getString(columnIndex);

        if (value == null || value.trim().length() == 0) {
            return new ArrayList<>(0);
        }

        list = new ArrayList<>();
        for (String str : value.split(",")) {
            list.add(OrderStatusEnum.valueOf(Integer.valueOf(str.trim())));
        }
        return list;
    }

    @Override
    public List<OrderStatusEnum> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        List<OrderStatusEnum> list = null;
        String value = cs.getString(columnIndex);

        if (value == null || value.trim().length() == 0) {
            return new ArrayList<>(0);
        }

        list = new ArrayList<>();
        for (String str : value.split(",")) {
            list.add(OrderStatusEnum.valueOf(Integer.valueOf(str.trim())));
        }
        return list;
    }
}
