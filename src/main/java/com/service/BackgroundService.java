package com.service;

import com.pojo.Background;
import java.util.List;

public interface BackgroundService {
    Background queryImageById();
    List<Background> queryAllImages();
}
