package com.service.impl;

import com.common.utils.TimeUtils;
import com.mapper.VolunteerMapper;
import com.mapper.BasesMapper;
import com.pojo.vo.QueryVolunteerByIdVo;
import com.pojo.Volunteer;
import com.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerMapper volunteerMapper;

    @Autowired
    private BasesMapper basesMapper;

    @Override
    public Integer userApplication(Volunteer vo) {
        Volunteer application = volunteerMapper.queryVolunteerByBaseId(vo.getBase_id());
        Integer b_status = basesMapper.queryBasesById(vo.getBase_id()).getB_status();

        if (b_status == 2 || b_status == 3) {
            return 5;
        }
        if (application == null) {
            return 5;
        }
        if (application.getV_population() - application.getV_joinPopulation() <= 0 || application.getB_status() != 1) {
            return 2;
        }
        if (application.getV_end_time().before(TimeUtils.getNowTime())) {
            return 3;
        }
        if (application.getV_start_time().after(TimeUtils.getNowTime())) {
            return 4;
        }

        if (volunteerMapper.queryVolunteerById(vo.getUser_id()) != null) {
            return 6;
        }

        vo.setV_status(3);
        vo.setV_application_time(TimeUtils.getNowTime());
        volunteerMapper.userApplication(vo);
        return 1;
    }

    @Override
    public QueryVolunteerByIdVo queryVolunteerById(Integer user_id) {
        return volunteerMapper.queryVolunteerById(user_id);
    }

    @Override
    public Volunteer queryVolunteerByBaseId(Integer base_id) {
        return volunteerMapper.queryVolunteerByBaseId(base_id);
    }


}
