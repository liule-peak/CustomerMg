package edu.hainanu.service;

import edu.hainanu.bean.Customer;

/**
 * @Description 管理模块 负责增删改查
 * @Author 9527 Email：839119912@qq.com
 * @Version 1.0
 * @Date 2020/8/18
 */
public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
        if (total > customers.length - 1) {
            return false;
        } else {
            customers[total] = customer;
            total++;
            return true;
        }
    }

    public boolean replaceCustomer(int index, Customer cust) {
        if (index < 0 || index > total - 1) {
            return false;
        } else {
            customers[index] = cust;
            return true;
        }
    }

    public boolean deleteCustomer(int index) {
        if (index < 0 || index > total - 1) {
            return false;
        } else {
            for (int i = index; i < total; i++) {
                customers[i] = customers[i + 1];
            }
            customers[total - 1] = null;
            total--;
            return true;
        }
    }

    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total + 1];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        } else {
            return customers[index];
        }
    }

    public int getTotal() {
        return total;
    }

}
