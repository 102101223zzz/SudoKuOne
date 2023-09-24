package com.hs.sudokuone.service;

import com.hs.sudokuone.pojo.Record;

import java.util.List;
import java.util.Map;

public interface RecordService {
    Map<String,Object> InsertRecord(String name, String time);
    List<Record> SelectAll();
}
