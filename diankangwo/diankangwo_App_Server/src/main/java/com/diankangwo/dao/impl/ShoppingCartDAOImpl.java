package com.diankangwo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.diankangwo.dao.ShoppingCartDAO;
import com.diankangwo.domain.ShoppingCart;

@Repository
public class ShoppingCartDAOImpl extends BaseDaoImpl<ShoppingCart> implements ShoppingCartDAO {

	@Override
	public List<ShoppingCart> findByUserId(Integer id) {
		List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
		shoppingCartList =  findByQuery("from ShoppingCart where userId = ? ", id);
		if (shoppingCartList == null || shoppingCartList.size() ==0) {
			return null;
		}else{
			return shoppingCartList;
		}
	}

}
