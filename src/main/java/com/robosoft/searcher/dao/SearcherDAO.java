package com.robosoft.searcher.dao;

import com.robosoft.searcher.entity.PhotosAndVideos;
import org.springframework.data.jpa.repository.Query;

public class SearcherDAO extends JpaRepository<PhotosAndVideos, Integer> {

	@Query("Select a from DocumnentStorageProperties a where user_id = ?1 and document_type = ?2")

	PhotosAndVideos checkDocumentByUserId(Integer userId, String docType);

	@Query("Select fileName from DocumnentStorageProperties a where user_id = ?1 and document_type = ?2")

	String getUploadDocumnetPath(Integer userId, String docType);

}
