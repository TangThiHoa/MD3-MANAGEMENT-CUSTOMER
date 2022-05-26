package service;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    List<Customer> customers;

    public CustomerServiceImpl() {
        customers = new ArrayList<>();
        customers.add(new Customer(1,"tth",123));
        customers.add(new Customer(2,"eth",1023));
        customers.add(new Customer(3,"hth",1253));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);

    }

    @Override
    public int findIndexById(int id) {
        int indexOf = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id){
                return i;
            }

        }
        return indexOf;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer:customers) {
            if (customer.getId()==id){
                return customer;
            }

        }
        return null;
    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    @Override
    public void update(int id, Customer customer) {
        int indexOf = findIndexById(id);
        customers.set(indexOf,customer);

    }

    @Override
    public void delete(int id) {

        customers.remove(findById(id));

    }
}
