package com.diankangwo.dao;

import java.util.List;
import com.diankangwo.domain.ShoppingCart;

public interface ShoppingCartDAO extends BaseDAO<ShoppingCart> {

	public List<ShoppingCart> findByUserId(Integer id);
}
