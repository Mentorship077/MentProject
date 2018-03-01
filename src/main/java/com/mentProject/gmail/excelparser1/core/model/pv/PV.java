package com.mentProject.gmail.excelparser1.core.model.pv;

import java.util.ArrayList;
import java.util.List;

/**
 * Java Model for Product-Vendor entity representation
 */
public class PV {

    private String productNumber;

    private Product product;

    private List<Vendor> vendors;


    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Vendor> getVendors() {
        if (vendors == null) {
            vendors = new ArrayList<>();
        }
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

}
