package com.hs.sudokuone.controller;

import com.hs.sudokuone.pojo.Record;
import com.hs.sudokuone.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Record")
public class RecordController {
    @Autowired
    RecordService  recordService;
    @RequestMapping("/InsertRecord")
    public Map<String,Object> InsertRecord(String name, String time){
        return recordService.InsertRecord(name,time);
    }
    @RequestMapping("/SelectAll")
    public List<Record> SelectAll(){
        return recordService.SelectAll();
    }
}
