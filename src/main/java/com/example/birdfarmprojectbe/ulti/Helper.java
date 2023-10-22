package com.example.birdfarmprojectbe.ulti;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

public class Helper {
    public static LocalDateTime convertStringToLocalDateTime(String requestTime) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(requestTime, formatter);
        return dateTime;
    }

    public static void setParam(PreparedStatement ps, int index, Integer value) throws SQLException {
        if (value == null) {
            ps.setNull(index, Types.INTEGER);
        } else {
            ps.setInt(index, value);
        }
    }

    public static void setParam(PreparedStatement ps, int index, Long value) throws SQLException {
        if (value == null) {
            ps.setNull(index, Types.LONGNVARCHAR);
        } else {
            ps.setLong(index, value);
        }
    }

    public static void setParam(PreparedStatement ps, int index, String value) throws SQLException {
        if (value == null) {
            ps.setNull(index, Types.NVARCHAR);
        } else {
            ps.setString(index, value);
        }
    }

    public static void setParam(PreparedStatement ps, int index) throws SQLException {
        ps.setNull(index, Types.NVARCHAR);
    }

    public static void setParam(PreparedStatement ps, int index, LocalDate value) throws SQLException {
        if (value == null) {
            ps.setNull(index, Types.NVARCHAR);
        } else {
            ps.setString(index, value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            ps.setString(index, value.toString());
        }
    }

    public static void setParam(PreparedStatement ps, int index, LocalDateTime value) throws SQLException {
        if (value == null) {
            ps.setNull(index, Types.NVARCHAR);
        } else {
            if (value.toString().length() != 19) {
                ps.setString(index, (value.toString()));
            } else {
                ps.setString(index, value.toString());
            }
        }
    }
}
