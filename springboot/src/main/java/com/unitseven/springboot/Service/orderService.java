package com.unitseven.springboot.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.unitseven.springboot.Entity.orders;
import com.unitseven.springboot.repository.ordersRepository;

@Service
public class orderService {
    @Autowired
    private ordersRepository repository;
    
    //create a new order
    public orders saveOrder(orders order) {
        return repository.save(order);
    }
    
    //read an existing order by ID
    public Optional<orders> getOrderById(int orderId) {
        return repository.findById(orderId);
    }
    
    //update an existing order
    public orders updateOrder(int orderId, orders updatedOrder) {
        Optional<orders> existingOrderOptional = repository.findById(orderId);
        if (existingOrderOptional.isPresent()) {
            updatedOrder.setOrder_id(orderId);
            return repository.save(updatedOrder);
        } else {
            return null; // Handle not found case
        }
    }
    
    //delete an existing order
    public void deleteOrder(int orderId) {
        repository.deleteById(orderId);
    }
    
    //get all orders
    public List<orders> getAllOrders() {
        return repository.findAll();
    }
}
