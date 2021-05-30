package wx.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import wx.mapper.OrderMapper;
import wx.poj.Order;
import java.util.*;
import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    private OrderMapper orderMapper;


    public void addOrder(Order order){
        orderMapper.insert(order);
    }

    public Page getAllOrder(String startTime, String endTime, Page page){
        QueryWrapper<Order> wrapper=new QueryWrapper();
        wrapper.between("create_time",startTime,endTime);
        return orderMapper.selectPage(page,wrapper);
    }
    public List<Order> getAllOrder2(String startTime, String endTime){
        QueryWrapper<Order> wrapper=new QueryWrapper();
        wrapper.between("create_time",startTime,endTime);

        return orderMapper.selectList(wrapper);
    }
      public List<Order> getAllOrders(){
        QueryWrapper<Order> wrapper=new QueryWrapper();
        return orderMapper.selectList(wrapper);
    }

    public int getOrderCount(){
        QueryWrapper<Order> wrapper=new QueryWrapper();
        return orderMapper.selectCount(wrapper);
    }
    public void changeStatus(Integer status,String orderId){
        UpdateWrapper<Order>wrapper=new UpdateWrapper<Order>();
        wrapper.eq("order_id",orderId).set("status",status);
        orderMapper.update(null,wrapper);
    }

    public Order getOrderById(String orderId){
        QueryWrapper<Order> wrapper=new QueryWrapper();
        wrapper.eq("order_id",orderId);
        return orderMapper.selectOne(wrapper);
    }

    public void deleteOrder(Integer id){
         orderMapper.deleteById(id);
    }


    public List<Order> getByUserId(Integer userId){
        QueryWrapper<Order> wrapper=new QueryWrapper();
        wrapper.eq("user_id",userId);
        return orderMapper.selectList(wrapper);
    }


}
