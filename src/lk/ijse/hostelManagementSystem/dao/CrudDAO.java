package lk.ijse.hostelManagementSystem.dao;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.dao.impl.custom.SuperDAO;

import java.util.List;

public interface CrudDAO <T ,ID> extends SuperDAO {

    void  save(T entity);

    void update(T entity);

    T serch(ID id);

    void delete(ID id);

}
