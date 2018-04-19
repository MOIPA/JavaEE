package com.tr.utils;

import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

public class BaseDataUtil {
    private static QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());

    public static QueryRunner getQueryRunner(){
        return qr;
    }

}
