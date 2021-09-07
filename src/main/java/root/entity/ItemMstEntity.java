package root.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * This class has item info per one 
 * @author daichi.akiba
 *
 */
@Entity
@Table(name = "item_mst")
@Data
public class ItemMstEntity {

    /* item ID */
    @Id
    private Integer id;
    
    /* item name */
    private String itemName;
    
    /* image name */
    private String imageName;
    
    /* price of item */
    private int price;
    
    /* brand name of item */
    private String brandName;
    
    /* item memo */
    private String itemMemo;
    
    /* used flag(if this 1, then the item is second hand) */
    private int usedFlg;

    private String imageId;
    
    /* sub image name */
    private String subImageName;
    
    /* 1:guitar, 2:bass, 3:acoustic guitar, 4:effector, 5:other */
    private int itemGenreCode;
    
    /* 0:selling, 1:sold out, 2:deleted */
    private int stateCode;
}
