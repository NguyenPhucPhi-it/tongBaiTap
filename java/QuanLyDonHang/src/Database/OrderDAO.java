package Database;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class OrderDAO {
    private Connection connection;
	private Order order;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    // Thêm đơn hàng mới
    public void addOrder(Order order) {
        String query = "INSERT INTO orders (order_id, customer_id, order_date, total_amount) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, order.getOrderId());
            stmt.setInt(2, order.getCustomerId());
            stmt.setTimestamp(3, Timestamp.valueOf(order.getOrderDate()));
            stmt.setBigDecimal(4, order.getTotalAmount());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách đơn hàng của khách hàng
    public List<Order> getOrdersByCustomerId(int customerId) {
        String query = "SELECT * FROM orders WHERE customer_id = ?";
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Order order = new Order(
                    rs.getInt("order_id"),
                    rs.getInt("customer_id"),
                    rs.getTimestamp("order_date").toLocalDateTime(),
                    rs.getBigDecimal("total_amount")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Tính tổng tiền đơn hàng
    public BigDecimal calculateTotalAmount(int orderId) {
        String query = "SELECT SUM(quantity * price) FROM order_items WHERE order_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    // Cập nhật tổng tiền cho đơn hàng
    public void updateOrderTotalAmount(Order order) {
        this.order = order;
		String query = "UPDATE orders SET total_amount = ? WHERE order_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setBigDecimal(1, order.getTotalAmount());
            stmt.setInt(2, order.getOrderId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
