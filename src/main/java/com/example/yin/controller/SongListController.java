package com.example.yin.controller;

import com.example.yin.service.impl.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongListController {
    @Autowired
    private SongListService songListService;
}
