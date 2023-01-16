package com.IULP.BackEnd.Service;

import com.IULP.BackEnd.Model.Obj;
import com.IULP.BackEnd.dao.ObjDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ObjService {
    @Autowired
    private ObjDao objDao;


    public List<Obj> getObjList(){
        return objDao.getObjList();
    }
    public Obj getObj(String obj){
        return objDao.getObj(obj);
    }

    public boolean deleteObj(String title){
        objDao.deleteObj(title);
        if(getObj(title).equals(null)) return false;
        else return true;
    }

}
