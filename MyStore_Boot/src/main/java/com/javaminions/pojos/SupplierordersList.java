package com.javaminions.pojos;

import java.util.ArrayList;
import java.util.List;


public class SupplierordersList {
    private List<Supplierorders> orders = new ArrayList<Supplierorders>();
    
    public SupplierordersList() {
    }

	public List<Supplierorders> getOrders() {
		return orders;
	}

	public void setSupplierOrdersList(List<Supplierorders> orders) {
		this.orders = orders;
	}
}
