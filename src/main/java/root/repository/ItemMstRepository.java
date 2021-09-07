package root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import root.entity.ItemMstEntity;

public interface ItemMstRepository extends JpaRepository<ItemMstEntity, Integer> {
    /**
     * To get item info by item genre and state code.
     * @param itemGenreCode 1:guitar, 2:bass, 3:acoustic guitar, 4:effector, 5:other
     * @param stateCode 0:selling, 1:sold out, 2:deleted
     * @return itemMstEntities
     */
    List<ItemMstEntity> findByItemGenreCodeAndStateCode(int itemGenreCode, int stateCode);

}
