package lk.ijse.hostelManagementSystem.dao;/*
    @author Dasun
*/

public interface CrudDAO <T ,ID> extends StudentDAO{

    void  save(T entity);
    void update(T entity);
    T serch(ID id);
    void delete(ID id);

}
