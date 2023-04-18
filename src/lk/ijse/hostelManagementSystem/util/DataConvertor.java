package lk.ijse.hostelManagementSystem.util;/*
    @author Dasun
*/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DataConvertor {

    private static DataConvertor dataConvertor;

    private DataConvertor(){}

    public <T> List<T> convert(List<?> list, Function function){
        List<T> tms = new ArrayList();
        for(int i = 0; i<list.size(); i++){
            tms.add((T) function.apply(list.get(i)));
        }
        return tms;
    }

    public static DataConvertor getInstance(){
        return dataConvertor==null? dataConvertor = new DataConvertor():dataConvertor;
    }
}
