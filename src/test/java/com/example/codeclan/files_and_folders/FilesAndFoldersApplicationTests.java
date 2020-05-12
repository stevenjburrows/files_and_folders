package com.example.codeclan.files_and_folders;

import com.example.codeclan.files_and_folders.models.File;
import com.example.codeclan.files_and_folders.models.Folder;
import com.example.codeclan.files_and_folders.models.User;
import com.example.codeclan.files_and_folders.repositories.FileRepository;
import com.example.codeclan.files_and_folders.repositories.FolderRepository;
import com.example.codeclan.files_and_folders.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesAndFoldersApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private FolderRepository folderRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void basicTest() {

		User steven = new User("Steven");
		userRepository.save(steven);



		Folder accounts = new Folder("Accounts", steven);
		folderRepository.save(accounts);

		File current = new File("current", "CSV", 1234, accounts);
		fileRepository.save(current);


	}

}
