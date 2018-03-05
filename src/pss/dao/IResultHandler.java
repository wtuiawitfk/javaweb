package pss.dao;

import java.sql.ResultSet;


public interface IResultHandler<T> {
    T handle(ResultSet rs) throws Exception;
}
