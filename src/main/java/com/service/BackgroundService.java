package com.service;

import com.pojo.Background;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BackgroundService {
    Background queryImageById();
    List<Background> queryAllImages();
}
