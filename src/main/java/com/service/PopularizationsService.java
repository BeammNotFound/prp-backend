package com.service;

import com.pojo.Popularizations;

public interface PopularizationsService {
    Popularizations queryPopularizations();
    void createPopularization(Popularizations popularizations);
}
