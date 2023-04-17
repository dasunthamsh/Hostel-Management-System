package lk.ijse.hostelManagementSystem.dao;/*
    @author Dasun
*/

public interface CrudDAO <T ,ID> extends SuperDAO {

    boolean  save(T entity);

    boolean update(T entity);

    T serch(ID id);

    void delete(ID id);

}
