package Database;

import java.sql.*;

public class CustomerDAO {
    private Connection connection;

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }

    // Thêm khách hàng mới
    public void addCustomer(Customer customer) {
        String query = "INSERT INTO customers (customer_id, customer_name, email, phone_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customer.getCustomerId());
            stmt.setString(2, customer.getCustomerName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhoneNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy thông tin khách hàng theo ID
    public Customer getCustomerById(int customerId) {
        String query = "SELECT * FROM customers WHERE customer_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt("customer_id"), rs.getString("customer_name"), rs.getString("email"), rs.getString("phone_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
public void addNewOrder(Order order, List<OrderItem> items) {
    orderDAO.addOrder(order);

    // Thêm các sản phẩm vào bảng order_items
    for (OrderItem item : items) {
        orderItemDAO.addOrderItem(item);
    }

    // Tính tổng tiền và cập nhật vào bảng orders
    BigDecimal totalAmount = orderDAO.calculateTotalAmount(order.getOrderId());
    order.setTotalAmount(totalAmount);
    orderDAO.updateOrderTotalAmount(order);
}
public List<Order> getOrderHistory(int customerId) {
    return orderDAO.getOrdersByCustomerId(customerId);
}
BigDecimal totalAmount = orderDAO.calculateTotalAmount(orderId);
System.out.println("Total amount for order " + orderId + ": " + totalAmount);



