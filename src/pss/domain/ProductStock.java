package pss.domain;
// 库存类

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStock {
    private Long id; // 库存编号
    private Long product_id; // 商品分类
    private Integer storeNum; // 商品库存
    private Date lastIncomeDate; // 商品入库时间
    private Date lastOutcomeDate; // 商品出库时间
    private Integer warningNum; // 警戒线商品数量
}