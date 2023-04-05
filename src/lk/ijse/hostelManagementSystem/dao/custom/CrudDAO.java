package lk.ijse.hostelManagementSystem.dao.custom;/*
    @author Dasun
*/

import lk.ijse.hostelManagementSystem.dao.custom.SuperDAO;

public interface CrudDAO <T ,ID> extends SuperDAO {

    void  save(T entity);

    void update(T entity);

    T serch(ID id);

    void delete(ID id);

}
