package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB
        maxFileSize = 1024 * 1024 * 10,       // 10 MB
        maxRequestSize = 1024 * 1024 * 100    // 100 MB
)
public class Upload extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Điều hướng sang trang jsp hiển thị form upload
        req.getRequestDispatcher("/views/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            // 1. Lấy thành phần file "photo" từ form gửi lên qua đối tượng Part
            Part filePart = req.getPart("photo");

            // 2. Lấy tên file gốc (ví dụ: "avatar.png")
            String fileName = filePart.getSubmittedFileName();

            if (fileName != null && !fileName.isEmpty()) {
                // 3. Định vị đường dẫn vật lý tuyệt đối đến thư mục /static/file trên server ứng dụng
                String uploadDir = req.getServletContext().getRealPath("/static/file");

                // Tạo thư mục nếu nó chưa tồn tại ngoài thực tế
                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // 4. Tạo đường dẫn file đầy đủ và thực hiện ghi file (Lưu file) vào ổ cứng server
                String fullPath = uploadDir + File.separator + fileName;
                filePart.write(fullPath);

                // In ra console đường dẫn thật để bạn dễ dàng tìm file kiểm tra
                System.out.println("File được lưu tại: " + fullPath);

                // 5. Trả dữ liệu thành công về cho JSP
                req.setAttribute("message", "Upload file thành công!");
                req.setAttribute("imagePath", "/static/file/" + fileName);
            } else {
                req.setAttribute("message", "Vui lòng chọn một file hợp lệ trước khi bấm Upload.");
            }

        } catch (Exception e) {
            req.setAttribute("message", "Lỗi xử lý upload: " + e.getMessage());
            e.printStackTrace();
        }

        // Luôn forward lại trang jsp để hiển thị thông báo kết quả
        req.getRequestDispatcher("/views/upload.jsp").forward(req, resp);
    }
}