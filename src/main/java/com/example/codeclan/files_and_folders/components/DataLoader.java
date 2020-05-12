package com.example.codeclan.files_and_folders.components;

import com.example.codeclan.files_and_folders.models.File;
import com.example.codeclan.files_and_folders.models.Folder;
import com.example.codeclan.files_and_folders.models.User;
import com.example.codeclan.files_and_folders.repositories.FileRepository;
import com.example.codeclan.files_and_folders.repositories.FolderRepository;
import com.example.codeclan.files_and_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FolderRepository folderRepository;


    public void run(ApplicationArguments args) throws Exception {

        User steven = new User("Steven");
        userRepository.save(steven);

        User fiona = new User("Fiona");
        userRepository.save(fiona);

        Folder accounts = new Folder("Accounts", steven);
        folderRepository.save(accounts);

        File current = new File("current", "CSV", 1234, accounts);
        fileRepository.save(current);

        File currentReport = new File("Current Report", "PDF", 123, accounts);
        fileRepository.save(currentReport);

        Folder pastAccounts = new Folder("Past Accounts", steven);
        folderRepository.save(pastAccounts);

        File previous = new File("Previous Accounts", "CSV", 1234, accounts);
        fileRepository.save(previous);

        File previousReport = new File("Previous Report", "PDF", 123, accounts);
        fileRepository.save(previousReport);



        Folder activities = new Folder("Activities", fiona);
        folderRepository.save(activities);

        File play = new File("playgrou", "cal", 1234, activities);
        fileRepository.save(play);

        File school = new File("School report", "PDF", 654, activities);
        fileRepository.save(school);

        File food = new File("Shopping list", "todo", 654, activities);
        fileRepository.save(food);

    }
}
