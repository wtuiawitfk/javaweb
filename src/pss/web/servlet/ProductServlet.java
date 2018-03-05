package pss.web.servlet;

import pss.dao.IProductDAO;
import pss.dao.IProductDirDAO;
import pss.dao.impl.ProductDaoImpl;
import pss.dao.impl.ProductDirDaoImpl;
import pss.domain.Product;
import pss.domain.ProductDir;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    private IProductDAO productDao = new ProductDaoImpl();
    private IProductDirDAO dirDAO = new ProductDirDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String cmd = req.getParameter("cmd");
        switch (cmd) {
            case "list":
                this.list(req, resp);
                break;
            case "delete":
                this.delete(req, resp);
                break;
            case "saveOrUpdate":
                this.saveOrUpdate(req, resp);
                break;
            case "edit":
                this.edit(req, resp);
                break;
            default:
                this.list(req, resp);
                break;
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = productDao.list();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/view/product/listProduct.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO 这里添加删除功能
        Long id = Long.valueOf(req.getParameter("id"));
        productDao.delete(id);
        req.getRequestDispatcher("/product?cmd=list").forward(req, resp);
    }

    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String productName = req.getParameter("productName");
        String brand = req.getParameter("brand");
        String supplier = req.getParameter("supplier");
        String salePrice = req.getParameter("salePrice");
        String costPrice = req.getParameter("costPrice");
        String cutoff = req.getParameter("cutoff");
        String dir_id = req.getParameter("productDir");
        ProductDir productDir = dirDAO.get(Long.valueOf(dir_id));
        Product product = new Product(null, productName, new BigDecimal(salePrice), supplier, brand, Double.valueOf(cutoff), new BigDecimal(costPrice), productDir);
        if (id == null || "".equals(id)) {
            productDao.save(product);
        } else {
            product.setId(Long.valueOf(id));
            productDao.update(product);
        }
        resp.sendRedirect(req.getContextPath() + "/product?cmd=list");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<ProductDir> dirs = dirDAO.list();
        req.setAttribute("dir", dirs);
        if (id == null || id == "") {
            req.getRequestDispatcher("/WEB-INF/view/product/editProduct.jsp").forward(req, resp);
        } else {
            Product product = productDao.get(Long.valueOf(id));
            req.setAttribute("pro", product);
            req.getRequestDispatcher("/WEB-INF/view/product/editProduct.jsp").forward(req, resp);
        }
    }
}
