package com.onlineclass.onlineclass.controller;


import com.onlineclass.onlineclass.entity.Classdemo;
import com.onlineclass.onlineclass.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;







@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping("/create")
    public Classdemo createClass(@RequestBody Classdemo classdemo) {
        return classService.saveClass(classdemo);
    }

    @GetMapping("/{id}")
    public Classdemo getClass(@PathVariable Long id) {
        return classService.getClassById(id);
    }
}
