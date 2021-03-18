package com.controller.MController;

import com.common.api.Action;
import com.common.api.CommonResult;
import com.common.utils.UpLoadImages;
import com.pojo.BaseMessages;
import com.pojo.BasesImages;
import com.pojo.vo.BaseIdVo;
import com.pojo.vo.BaseMessageIdVo;
import com.pojo.vo.BasesVo;
import com.service.BasesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author BeamStark
 * @Version 0.1 2020/12
 */
@Api(tags = "后台基地接口")
@RestController
public class BasesManageController {

    @Autowired
    private BasesService service;

//    @ApiOperation("根据基地名模糊搜索基地信息")
//    @Action(description = "根据基地名模糊搜索基地信息")
//    @PostMapping("fuzzyQueryBases")
//    public CommonResult fuzzyQueryBases(@Validated @RequestBody QueryBasesVo basesVo, BindingResult result) {
//        if (result.hasErrors()) {
//            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
//        }
//
//        List<Bases> bases = service.fuzzyQueryBases(basesVo);
//        if (bases == null || bases.size() == 0) {
//            return CommonResult.validateFailed("查不到内容呢 QAQ ,检查一下搜索内容~");
//        }
//        return CommonResult.success(service.fuzzyQueryBases(basesVo));
//    }

    @ApiOperation("根据base_id注销基地")
    @Action(description = "根据base_id注销基地")
    @PostMapping("delBasesByBaseId")
    public CommonResult delBases(@Validated @RequestBody BaseIdVo baseIdVo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        service.delBases(baseIdVo);
        return CommonResult.success("基地注销成功！");
    }

    @ApiOperation("根据bm_id修改基地资讯")
    @Action(description = "根据bm_id修改基地资讯")
    @PostMapping("changeBasesMessagesById")
    public CommonResult changeBasesMessagesById(@RequestBody BaseMessages po) {
        service.changeBasesMessagesById(po);
        return CommonResult.success("修改基地资讯成功！");
    }

    @ApiOperation("插入基地资讯")
    @Action(description = "插入基地资讯")
    @PostMapping("insertBasesMessage")
    public CommonResult insertBasesMessage(@RequestBody BaseMessages po) {
        service.insertBasesMessage(po);
        return CommonResult.success("插入基地咨询成功！资讯标题为：" + po.getBm_title());
    }

    @ApiOperation("根据bm_id删除基地资讯")
    @Action(description = "根据bm_id删除基地资讯")
    @PostMapping("delBasesMessageByBmId")
    public CommonResult delBasesMessageByBmId(@Validated @RequestBody BaseMessageIdVo vo, BindingResult result) {
        if (result.hasErrors()) {
            return CommonResult.validateFailed(result.getFieldError().getDefaultMessage());
        }
        service.delBasesMessageByBmId(vo);
        return CommonResult.success("删除活动成功！id为：" + vo.getBm_id());
    }

    @ApiOperation("根据base_id更改基地信息")
    @Action(description = "根据base_id更改基地信息")
    @PostMapping("changeBasesByBaseId")
    public CommonResult changeBasesById(@RequestBody BasesVo po) {
        service.changeBasesById(po);
        return CommonResult.success("修改信息成功！基地id为" + po.getBase_id());
    }

    @ApiOperation("根据bi_id修改地基图片")
    @Action(description = "根据bi_id修改地基图片")
    @PostMapping("changeBasesImageByBiId")
    public CommonResult changeBasesImageByBiId(Integer bi_id, MultipartFile image) {
        if (bi_id == null)
            return CommonResult.validateFailed("bi_id不能为空！");
        BasesImages po = new BasesImages();
        if (image != null) {
            try {
                po.setBi_image(new UpLoadImages().uploadImage(image));
            } catch (IOException e) {
                CommonResult.validateFailed("上传图片失败！");
                e.printStackTrace();
            }
        }
        po.setBi_id(bi_id);
        service.changeBasesImageByBiId(po);
        return CommonResult.success(po.getBi_image());
    }
    @ApiOperation("根据base_id修改地头像")
    @Action(description = "根据base_id修改地头像")
    @PostMapping("changeBasesIconByBaseId")
    public CommonResult changeBasesIconByBaseId(Integer base_id, MultipartFile base_icon) {
        if (base_id == null)
            return CommonResult.validateFailed("base_id不能为空！");

        BasesVo vo = new BasesVo();
        if (base_icon != null) {
            try {
                vo.setB_icon(new UpLoadImages().uploadImage(base_icon));
            } catch (IOException e) {
                CommonResult.validateFailed("上传图片失败！");
                e.printStackTrace();
            }
        }
        vo.setBase_id(base_id);
        service.changeBasesIconByBaseId(vo);
        return CommonResult.success(vo.getB_icon());
    }

    @ApiOperation("根据bm_id上传基地资讯图片")
    @Action(description = "根据bm_id上传基地资讯图片")
    @PostMapping("uploadBaseMessageImageByBmId")
    public CommonResult uploadBaseMessageImageByBmId(Integer bm_id, MultipartFile baseMessageImage) {
        if (bm_id == null || bm_id == 0) {
            return CommonResult.validateFailed("bm_id不能为空");
        }
        BaseMessages po = new BaseMessages();
        if (baseMessageImage != null) {
            try {
                po.setBm_image(new UpLoadImages().uploadImage(baseMessageImage));
            } catch (IOException e) {
                CommonResult.validateFailed("图片上传失败！");
                e.printStackTrace();
            }
            po.setBm_id(bm_id);
        }
        service.changeBasesMessagesById(po);
        return CommonResult.success(po.getBm_image());
    }

}
