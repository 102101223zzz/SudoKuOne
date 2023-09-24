package com.hs.sudokuone.service.Impl;

import com.hs.sudokuone.mapper.RecordMapper;
import com.hs.sudokuone.pojo.Record;
import com.hs.sudokuone.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    RecordMapper recordMapper;
    public Map<String, Object> InsertRecord(String name, String time){
       Map<String,Object> map=new HashMap<>();

        if(recordMapper.SelectOne(name)!=null)
        {
            map.put("msg","该用户已存在");
            return map;
        }
       else recordMapper.InsertRecord(name,time);
        map.put("msg","插入成功");
        return map;
    }
    public List<Record> SelectAll(){
        return recordMapper.SelectAll();
    }
}
