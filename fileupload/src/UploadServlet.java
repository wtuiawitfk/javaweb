import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/upload")

public class UploadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先判断JSP页面提交的数据编码形式：multipart/form-data
        boolean multipartContent = ServletFileUpload.isMultipartContent(req);
        if (!multipartContent) {
            return;
        }

        try {
            //创建一个fileItemFactory类
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            //使用fileItemFactory创建一个ServletFileUpload对象
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            //解析请求对象
            List<FileItem> list = fileUpload.parseRequest(req);
            for (FileItem item:
                list ) {
                //判断item内的控件是否为上传控件
                if (!item.isFormField()) {
                    //上传文件 macos 文件地址从"/"开始
                    item.write(new File("/Users/yuhonghao", "jpg.jpg"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
