package root.dto;

import java.util.List;

import javax.persistence.Id;

import lombok.Data;

@Data
public class ItemDetailWithImgNamesDto {
    
    /* item id */
    @Id
    private Integer id;
    
    /* item name */
    private String itemName;
    
    /* main image name */
    private String imageName;
    
    /* sub image name */
    private List<String> subImageNames;
    
    /* price of item */
    private int price;
    
    /* brand name of item */
    private String brandName;
    
    /* item memo */
    private String itemMemo;
    
    /* used flag(if this 1, then the item is second hand) */
    private int usedFlg;
    
    /* 0:selling, 1:sold out, 2:deleted */
    private int stateCode;
    
    /* 1:guitar, 2:bass, 3:acoustic guitar, 4:effector, 5:other */
    private int itemGenreCode;

}
