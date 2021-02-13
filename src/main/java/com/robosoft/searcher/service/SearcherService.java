package com.robosoft.searcher.service;

@Service
public class SearcherService {

	@Autowired
	SearcherDAO searcherDAO;

	public Resource loadFileAsResource(String fileName) throws Exception {

		try {

			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();

			Resource resource = new UrlResource(filePath.toUri());

			if (resource.exists()) {

				return resource;

			} else {

				throw new FileNotFoundException("File not found " + fileName);

			}

		} catch (MalformedURLException ex) {

			throw new FileNotFoundException("File not found " + fileName);

		}

	}

	public String getDocumentName(Integer userId, String docType) {
		return searcherDAO.getUploadDocumnetPath(userId, docType);
	}

}
