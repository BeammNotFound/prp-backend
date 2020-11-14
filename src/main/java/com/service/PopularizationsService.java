package com.service;

import com.pojo.Popularizations;
import java.util.List;

public interface PopularizationsService {
    List<Popularizations> queryPopularizations(Popularizations popularizations);
    void createPopularization(Popularizations popularizations);
    List<Popularizations> fuzzyQueryPopularizations(Popularizations popularizations);
}
