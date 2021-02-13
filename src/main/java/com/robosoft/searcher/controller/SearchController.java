package com.robosoft.searcher.controller;

@RestController
public class SearchController {

	@GetMapping("/getPhotosAndVideos")
	public ResponseEntity<Resource> downloadFile(@RequestParam("userId") Integer userId,

			@RequestParam("docType") String docType,

			HttpServletRequest request) {

		String fileName = documneStorageService.getDocumentName(userId, docType);

		Resource resource = null;

		if (fileName != null && !fileName.isEmpty()) {

			try {

				resource = documneStorageService.loadFileAsResource(fileName);

			} catch (Exception e) {

				e.printStackTrace();

			}

			// Try to determine file's content type

			String contentType = null;

			try {

				contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

			} catch (IOException ex) {

				// logger.info("Could not determine file type.");

			}

			// Fallback to the default content type if type could not be determined

			if (contentType == null) {

				contentType = "application/octet-stream";

			}

			return ResponseEntity.ok()

					.contentType(MediaType.parseMediaType(contentType))

					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")

					.body(resource);

		} else {

			return ResponseEntity.notFound().build();

		}

	}

}
