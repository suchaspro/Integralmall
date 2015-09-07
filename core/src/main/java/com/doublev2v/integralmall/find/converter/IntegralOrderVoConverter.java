package com.doublev2v.integralmall.find.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.integralmall.find.entity.IntegralOrderVo;
import com.doublev2v.integralmall.merchandise.Coupon;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.order.IntegralOrder;
import com.doublev2v.integralmall.order.om.OrderMerchandise;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.DateUtil;

@Component
public class IntegralOrderVoConverter extends SimpleDtoConverter<IntegralOrder, IntegralOrderVo> {

	@Override
	public IntegralOrderVo convert(IntegralOrder d) {
		IntegralOrderVo t=new IntegralOrderVo();
		t.setId(d.getId());
		t.setOrderDate(d.getOrderDate());
		t.setOrderNo(d.getOrderNo());
		t.setStatus(d.getStatus());
		OrderMerchandise om=d.getOrderMerchandise();
		if(om!=null){
			Merchandise m=om.getMerchandise();
			if(m!=null){
				t.setName(m.getName());
				if(m.getBrand()!=null){
					t.setBrandName(m.getBrand().getName());
				}
				if(m.getClassify()!=null){
					t.setClassifyName(m.getClassify().getName());
				}
				if(m.getMainPicMedia()!=null){
					t.setMainPic(m.getMainPicMedia().getUrl());
				}
				t.setUsageDate("");
				t.setCouponCode("");
				switch(m.getType()){
				case Constant.VIRTUAL:
					t.setType(Constant.VIRTUAL);
					Coupon c=(Coupon)m;
					if(m.getEndDate()!=null){
						t.setExpiryTime(DateUtil.format(m.getEndDate()));
					}
					t.setAddress(c.getAddress());
					t.setShopName(c.getShop().getName());
					t.setLongitude(c.getLongitude());
					t.setLatitude(c.getLatitude());
					if(om.getUsageDate()!=null){
						t.setUsageDate(DateUtil.format(om.getUsageDate()));	
					}
					if(StringUtils.isNotBlank(om.getCouponCode())){
						t.setCouponCode(om.getCouponCode());
					}
					break;
				case Constant.ACTUAL:
					t.setType(Constant.ACTUAL);
					break;
				}
			}			
			
		}
		
		return t;
	}
	@Override
	public IntegralOrderVo convertSimple(IntegralOrder d) {
		IntegralOrderVo t=new IntegralOrderVo();
		t.setId(d.getId());
		t.setStatus(d.getStatus());
		OrderMerchandise om=d.getOrderMerchandise();
		if(om!=null){
			Merchandise m=om.getMerchandise();
			if(m!=null){
				t.setName(m.getName());
				if(m.getBrand()!=null){
					t.setBrandName(m.getBrand().getName());
				}
				if(m.getClassify()!=null){
					t.setClassifyName(m.getClassify().getName());
				}
				
				if(m.getMainPicMedia()!=null){
					t.setMainPic(m.getMainPicMedia().getUrl());
				}
				switch(m.getType()){
				case Constant.VIRTUAL:
					t.setType(Constant.VIRTUAL);
					Coupon c=(Coupon)m;
					if(m.getEndDate()!=null){
						t.setExpiryTime(DateUtil.format(m.getEndDate()));
					}
					t.setAddress(c.getAddress());
					t.setShopName(c.getShop().getName());
					t.setLongitude(c.getLongitude());
					t.setLatitude(c.getLatitude());
					break;
				case Constant.ACTUAL:
					t.setType(Constant.ACTUAL);
					break;
				}
			}
		}
		
		return t;
	}

}