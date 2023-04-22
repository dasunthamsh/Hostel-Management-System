package lk.ijse.hostelManagementSystem.dao;/*
    @author Dasun
*/

public interface CrudDAO <T ,ID> extends SuperDAO {

    boolean  save(T entity)throws Exception;

    boolean update(T entity)throws Exception;

    T serch(ID id)throws Exception;

    boolean delete(ID id )throws Exception;

}
