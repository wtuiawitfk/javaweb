package pss.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id; // 商品编号
    private String productName; // 商品名称
    private BigDecimal salePrice; // 售价
    private String supplier; // 供应商
    private String brand; // 商标
    private Double cutoff; // 折价
    private BigDecimal costPrice; // 成本价

    private ProductDir productDir;  //商品分类
}
