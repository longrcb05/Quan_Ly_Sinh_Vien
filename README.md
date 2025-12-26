🎓 Đồ án: Xây dựng Ứng dụng Quản Lý Sinh Viên
📌 Thông tin chung
Tên đề tài: Xây dựng ứng dụng Quản Lý Sinh Viên
Sinh viên thực hiện: Nguyễn Nhật Long
GDHD: Trần Kim Sanh
Công cụ phát triển: Eclipse IDE

🎯 Mô tả dự án
Dự án Quản Lý Sinh Viên là một ứng dụng desktop được xây dựng bằng ngôn ngữ Java với giao diện Java Swing (JFrame).
Ứng dụng cho phép quản lý thông tin sinh viên thông qua giao diện trực quan, dễ sử dụng, phục vụ cho các yêu cầu quản lý cơ bản trong môi trường giáo dục.

⚠️ Lưu ý:
Dự án không sử dụng cơ sở dữ liệu
Dữ liệu sinh viên được quản lý trực tiếp trong chương trình (thông qua danh sách đối tượng trong bộ nhớ)

🚀 Công nghệ sử dụng
Ngôn ngữ: Java
Giao diện: Java Swing (JFrame, JPanel, JButton, JTable, …)
IDE: Eclipse
Lưu trữ dữ liệu: In-memory (ArrayList / Collection)

🏗️ Cấu trúc dự án
Dự án được tổ chức theo hướng đơn giản, rõ ràng, phù hợp với ứng dụng Java Swing cơ bản, không sử dụng database.

📁 Cấu trúc thư mục
Quan_Ly_Sinh_Vien/
└── Java_App
    └── Java_App
        ├── src
        │   └── java_app
        │       ├── QuanLySinhVien.java     # Lớp xử lý logic quản lý sinh viên
        │       ├── SinhVien.java           # Lớp đối tượng Sinh Viên
        │       └── GiaoDien.java           # JFrame giao diện chính
        │
        └── nbproject                      # Cấu hình dự án (NetBeans/Eclipse)

⚙️ Chức năng chính
Thêm thông tin sinh viên
Sửa thông tin sinh viên
Xóa sinh viên
Hiển thị danh sách sinh viên
Quản lý dữ liệu sinh viên thông qua danh sách trong bộ nhớ
Giao diện trực quan bằng Java Swing (JFrame)

▶️ Hướng dẫn chạy chương trình
Clone project:

git clone https://github.com/longrcb05/Quan_Ly_Sinh_Vien.git

Mở Eclipse IDE
Import project:
File → Import → Existing Projects into Workspace
Chọn thư mục Java_App
Mở file GiaoDien.java hoặc QuanLySinhVien.java
Run chương trình dưới dạng Java Application

📌 Ghi chú
Dự án được phát triển cho mục đích học tập tại CMU-CS 303 QIS 
Phát triển bởi: Nguyễn Nhật Long
