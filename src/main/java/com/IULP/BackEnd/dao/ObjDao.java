package com.IULP.BackEnd.dao;

import com.IULP.BackEnd.Model.Obj;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ObjDao {
    public List<Obj> getObjList();
    public Obj getObj(String title);
    public void deleteObj(String title);
}
