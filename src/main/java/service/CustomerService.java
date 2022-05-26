package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();                           //In toàn bộ danh sách

    void save(Customer customer);                       //Thêm , lưu sp

    int findIndexById(int id);                          //Tìm kiếm theo chỉ số index

    Customer findById(int id);                          //Tìm kiếm theo đối tượng

    List<Customer> findByName(String name);             //Tìm kiếm theo tên

    void update(int id, Customer customer);             //Chỉnh sửa theo id

    void delete(int id);                                //Xóa theo id


}
