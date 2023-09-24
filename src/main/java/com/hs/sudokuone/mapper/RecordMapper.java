package com.hs.sudokuone.mapper;
import com.hs.sudokuone.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public  interface RecordMapper {
    void InsertRecord(String name,String time);
    List<Record> SelectAll();
    Record SelectOne(String name);

}
