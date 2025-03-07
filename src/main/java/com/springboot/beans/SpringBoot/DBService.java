package com.springboot.beans.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {


//    @Autowired
     final private  DB db;
 DBService(DB db)
 {
     this.db=db;

 }


public String getData()
    {
        return db.getData();

    }
}
