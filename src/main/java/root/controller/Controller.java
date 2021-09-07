package root.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import root.awsImage.bucket.BucketName;
import root.awsImage.fileDownLoad.FileStore;
import root.dto.ItemDetailWithImgNamesDto;
import root.entity.ItemMstEntity;
import root.repository.ItemMstRepository;
import root.repository.ItemSubImageRepository;
import root.type.GenreType;

/**
 * Controller class to deal with HTTP requests.
 * @author daichi.akiba
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class Controller {

    private final ItemMstRepository itemMstRepository;
    
    private final ItemSubImageRepository itemSubImageRepository;

    private final FileStore fileStore;

    /**
     * To get item detail info with image names and return it to item detail screen.
     * @param id itemId
     * @return itemDetailWithPics
     */
    @GetMapping("/{id}")
    public ItemDetailWithImgNamesDto getItemDetailWithPics(@PathVariable final Integer id) {
        // get item info by id(item)
        final ItemMstEntity itemMstEntities = itemMstRepository.findById(id).orElse(null);
        // get sub image names by id(item)
        final List<String> subImages = itemSubImageRepository.findSubImageEntities(itemMstEntities.getId());
        
        final ItemDetailWithImgNamesDto itemDetailWithPics = new ItemDetailWithImgNamesDto();
        itemDetailWithPics.setSubImageNames(subImages);
        // The values of variables below are copied:
        // id, itemName, imageName, price, brandName, itemMemo, usedFlg, stateCode, itemGenreCode 
        BeanUtils.copyProperties(itemMstEntities, itemDetailWithPics);

        return itemDetailWithPics;
    }

    /**
     * To get selling item info by genre to return it to item page by the genre 
     * @param itemGenre
     * @return itemMstEntities
     */
    @GetMapping("/itempage/{itemGenre}")
    public List<ItemMstEntity> getItemInfo(@PathVariable final String itemGenre) {
        // get info of items with specified genre and state code 0 which is selling 
        final List<ItemMstEntity> itemMstEntities = itemMstRepository
                .findByItemGenreCodeAndStateCode(GenreType.valueOf(itemGenre).getValue(), 0);
        return itemMstEntities;
    }

    /**
     * To download item image
     * @param itemGenreCd
     * @param imageName
     * @param id
     * @return image as a byte array
     */
    @GetMapping("{itemGenreCd}/{imageName}/{id}/image/download")
    public byte[] downloadProfileImage(@PathVariable("itemGenreCd") final int itemGenreCd,
            @PathVariable("imageName") final String imageName, @PathVariable("id") final String id) {
        return fileStore.download(BucketName.PROFILE_IMAGE.getBucketName() + File.separator
                + GenreType.getGenreByCode(itemGenreCd) + File.separator + id, imageName);
    }

}
