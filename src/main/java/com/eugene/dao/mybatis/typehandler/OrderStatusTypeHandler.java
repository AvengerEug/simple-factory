package com.eugene.dao.mybatis.typehandler;


import com.eugene.Enum.OrderStatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderStatusTypeHandler extends BaseTypeHandler<OrderStatusEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    OrderStatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public OrderStatusEnum getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        Object value = rs.getInt(columnName);
        int intValue = -1;
        if (value != null) {
            intValue = ((Number) value).intValue();
        }
        return OrderStatusEnum.valueOf(intValue);
    }

    @Override
    public OrderStatusEnum getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        Object value = rs.getInt(columnIndex);
        int intValue = -1;
        if (value != null) {
            intValue = ((Number) value).intValue();
        }
        return OrderStatusEnum.valueOf(intValue);
    }

    @Override
    public OrderStatusEnum getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        Object value = cs.getInt(columnIndex);
        int intValue = -1;
        if (value != null) {
            intValue = ((Number) value).intValue();
        }
        return OrderStatusEnum.valueOf(intValue);
    }
}
