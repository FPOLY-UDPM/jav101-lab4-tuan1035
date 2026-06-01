package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dang-ky")
public class DangKy extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cấu hình tiếng Việt để tránh lỗi font khi hiển thị
        req.setCharacterEncoding("UTF-8");

        // Forward sang trang JSP để hiển thị Form ban đầu
        req.getRequestDispatcher("/views/dangky.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Bắt buộc phải có dòng này để đọc tiếng Việt không bị lỗi font từ form gửi lên
        req.setCharacterEncoding("UTF-8");

        // 1. Đọc các tham số ĐƠN TRỊ (req.getParameter)
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender"); // trả về "true" hoặc "false" dưới dạng String
        String married = req.getParameter("married"); // nếu tích chọn sẽ trả về "true", nếu không tích sẽ trả về null
        String nationality = req.getParameter("nationality");
        String note = req.getParameter("note");

        // 2. Đọc tham số ĐA TRỊ (req.getParameterValues) -> Trả về mảng String
        String[] hobbies = req.getParameterValues("hobbies");

        // 3. Xuất tất cả kết quả ra Console hệ thống để kiểm tra
        System.out.println("========= DỮ LIỆU ĐĂNG KÝ =========");
        System.out.println("Tên đăng nhập: " + username);
        System.out.println("Mật khẩu: " + password);
        System.out.println("Giới tính: " + (gender != null && gender.equals("true") ? "Nam" : "Nữ"));
        System.out.println("Tình trạng hôn nhân: " + (married != null ? "Đã kết hôn" : "Độc thân"));
        System.out.println("Quốc tịch: " + nationality);
        System.out.println("Ghi chú: " + note);

        // Kiểm tra mảng đa trị xem có dữ liệu không trước khi duyệt
        System.out.print("Sở thích: ");
        if (hobbies != null) {
            for (String hobby : hobbies) {
                System.out.print("[" + hobby + "] ");
            }
            System.out.println(); // Xuống dòng
        } else {
            System.out.println("Không chọn sở thích nào.");
        }
        System.out.println("Dang ky thanh cong");

        // Sau khi xử lý xong, bạn có thể thông báo hoặc tiếp tục forward lại form
        req.setAttribute("message", "Đăng ký thành công! Hãy kiểm tra trong Console IntelliJ.");
        req.getRequestDispatcher("/views/dangky.jsp").forward(req, resp);
    }
}