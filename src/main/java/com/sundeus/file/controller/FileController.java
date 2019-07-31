package com.sundeus.file.controller;

import java.io.IOException;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import com.google.cloud.Date;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.StorageOptions;
import com.sundeus.contract.model.Contract;
import com.sundeus.file.exception.FileNotFoundException;

import java.io.OutputStream;
import org.springframework.core.io.WritableResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class FileController {

	//@Value("gs://spring-bucket-pjagdaley/my-file.txt")
	//private Resource gcsFile;

	// Upload a new template
	@CrossOrigin
	@PostMapping("/uploadTemplate")
	public String uploadTemplate(@RequestParam("file") MultipartFile file) {
		// public String uploadTemplate(@RequestParam("file") MultipartFile file, int
		// contractTypeId) {

		if (file.isEmpty()) {
			throw new FileNotFoundException("File is empty");
		}

		Storage storage = StorageOptions.getDefaultInstance().getService();

		String bucket_name = "sundeus-bucket";

		Bucket bucket = storage.get(bucket_name);
		
		if (bucket==null) {
			bucket = storage.create(BucketInfo.of(bucket_name));			
		}

		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			
			String blob_name = "template/" + file.getOriginalFilename();

			Blob blob = bucket.create(blob_name, bytes);
			
			String documentId = "gs://" + bucket_name + "/" + blob.getName();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Success";
	}

	// Upload a new template
	@CrossOrigin
	@PostMapping("/uploadSupportingDoc")
	public String uploadSupportingDoc(@RequestParam("file") MultipartFile file) {
		// public String uploadTemplate(@RequestParam("file") MultipartFile file, int
		// contractTypeId) {

		if (file.isEmpty()) {
			throw new FileNotFoundException("File is empty");
		}

		Storage storage = StorageOptions.getDefaultInstance().getService();

		String bucket_name = "sundeus-bucket";

		Bucket bucket = storage.get(bucket_name);
		
		if (bucket==null) {
			bucket = storage.create(BucketInfo.of(bucket_name));			
		}

		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			
			String blob_name = "supportingDoc/" + file.getOriginalFilename();

			Blob blob = bucket.create(blob_name, bytes);
			
			String documentId = "gs://" + bucket_name + "/" + blob.getName();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Success";
	}

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * readGcsFile() throws IOException {
	 * 
	 * Storage storage = StorageOptions.getDefaultInstance().getService();
	 * 
	 * 
	 * 
	 * 
	 * Bucket bucket = storage.create(
	 * BucketInfo.newBuilder("baeldung-bucketpankaj") // See here for possible
	 * values: http://g.co/cloud/storage/docs/storage-classes
	 * .setStorageClass(StorageClass.MULTI_REGIONAL) // Possible values:
	 * http://g.co/cloud/storage/docs/bucket-locations#location-mr
	 * .setLocation("us-central1-b") .build());
	 * 
	 * 
	 * 
	 * Bucket bucket = storage.create(BucketInfo.of("baeldung-bucketpankaj"));
	 * String str=bucket.getLocation(); System.out.println("Location : "+bucket);
	 * String value = "Hello, World Pankaj Jagdaley!"; byte[] bytes =
	 * value.getBytes(); Blob blob = bucket.create("template/my-first-blob", bytes);
	 * //**************************************************
	 * System.out.println("Bucket: " + blob.getBucket()); System.out.println("Id: "
	 * + blob.getBlobId()); System.out.println("MediaLink: " + blob.getMediaLink());
	 * System.out.println("Metageneration: " + blob.getMetageneration());
	 * System.out.println("Name: " + blob.getName());
	 * //***************************************************** BlobId blobId=
	 * blob.getBlobId(); String uri= blob.toString();
	 * System.out.println("blobId : "+blobId);
	 * System.out.println("pankaj -------uri : "+uri); Blob blob1 =
	 * storage.get(blobId);
	 * 
	 * 
	 * String newString = "Bye now!"; //Blob blob2 = storage.get(blobId);
	 * System.out.println("Hello Pankaj"); WritableByteChannel channel =
	 * blob1.writer(); System.out.println("Hello Pankaj1");
	 * channel.write(ByteBuffer.wrap(newString.getBytes()));
	 * System.out.println("Hello Pankaj2"); //channel.close();
	 * System.out.println("Hello Pankaj3"); //String value2 = new
	 * String(blob1.getContent()); System.out.println("Hello Pankaj4"); String
	 * value1 = new String(blob1.getContent()); //return
	 * StreamUtils.copyToString(gcsFile.getInputStream(),Charset.defaultCharset()) +
	 * "\n"; return value1; }
	 */
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.POST) String
	 * writeGcs(@RequestBody String data) throws IOException { try (OutputStream os
	 * = ((WritableResource) gcsFile).getOutputStream()) {
	 * os.write(data.getBytes()); } return "file was updated\n"; }
	 */
}