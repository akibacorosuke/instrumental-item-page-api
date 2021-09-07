package root.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_sub_image")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemSubImageEntity {

    @Id
    private String imageId;
    
    private Integer itemId;
    
    private String subImageName;
    
    private int deleteFlg;
    
}
