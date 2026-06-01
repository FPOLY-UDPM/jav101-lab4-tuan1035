package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/tinhadd", "/tinhsub"})
public class CongTru extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "Nhập số và chọn phép tính");

        // SỬA LỖI 1: Phải forward sang file JSP (đổi tên file jsp cho đúng với file của bạn)
        req.getRequestDispatcher("/views/maytinh.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String path = req.getServletPath();

        try {
            // SỬA LỖI 2: Dùng .contains("add") để kiểm tra chính xác URL /tinhadd
            if(path.contains("add")) {
                double c = Double.parseDouble(a) + Double.parseDouble(b);
                req.setAttribute("message", a + " + " + b + " = " + c);
            } else {
                double c = Double.parseDouble(a) - Double.parseDouble(b);
                req.setAttribute("message", a + " - " + b + " = " + c);
            }
        } catch (Exception e) {
            req.setAttribute("message", "Vui lòng nhập đúng định dạng số!");
        }

        // SỬA LỖI 1: doPost cũng phải forward sang file JSP để hiển thị kết quả
        req.getRequestDispatcher("/views/maytinh.jsp").forward(req, resp);
    }
}