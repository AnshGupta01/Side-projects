package com.dao;

import com.entities.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ToDoDao {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Transactional
    public int save(ToDo t){
        Integer i = (Integer) hibernateTemplate.save(t);
        return i;
    }

    public List<ToDo> getAll(){
        List<ToDo> toDos = this.hibernateTemplate.loadAll(ToDo.class);
        return toDos;
    }

}
