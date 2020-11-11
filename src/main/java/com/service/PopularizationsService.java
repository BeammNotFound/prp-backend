package com.service;

import com.pojo.Popularizations;
import java.util.List;

public interface PopularizationsService {
    List<Popularizations> queryPopularizations();
    void createPopularization(Popularizations popularizations);
}
