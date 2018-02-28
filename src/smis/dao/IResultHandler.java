package smis.dao;

import java.sql.ResultSet;

public interface IResultHandler<T> {
    T handle(ResultSet resultSet)throws Exception;
}
