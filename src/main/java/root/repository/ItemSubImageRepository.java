package root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import root.entity.ItemSubImageEntity;

public interface ItemSubImageRepository extends JpaRepository<ItemSubImageEntity, String> {

    @Query(value = "select sub_image_name "
            + "from item_sub_image "
            + "where item_id = :itemId and delete_flg = 0", nativeQuery = true)
    public List<String> findSubImageEntities(@Param("itemId") Integer itemId);

}
