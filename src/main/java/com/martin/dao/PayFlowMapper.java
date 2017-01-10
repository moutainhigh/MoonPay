package com.martin.dao;

import com.martin.bean.PayFlowBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName: PayFlowMapper
 * @Description: 支付流水
 * @author ZXY
 * @date 2016/7/1 10:13
 */
@Repository
public interface PayFlowMapper extends Mapper<PayFlowBean> {

    List<PayFlowBean> getPayFlowListByBiz(@Param("bizId") String bizId, @Param("bizType") Integer bizType);

    PayFlowBean getPayFlowById(@Param("flowId") Long flowId, @Param("payState") Integer payState);

    List<PayFlowBean> selectListById(@Param("flowIdList") List<String> flowIdList, @Param("payState") Integer payState);

    PayFlowBean selectByThdId(@Param("thdFlowId") String thdFlowId, @Param("payState") Integer payState);

    int updateThdFlowId(@Param("flowId") Long flowId, @Param("thdFlowId") String thdFlowId);
}