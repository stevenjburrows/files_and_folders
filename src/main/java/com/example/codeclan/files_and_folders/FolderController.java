package com.example.codeclan.files_and_folders;

import com.example.codeclan.files_and_folders.models.Folder;
import com.example.codeclan.files_and_folders.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders() {
        List<Folder> foundFolder = folderRepository.findAll() ;
        return  new ResponseEntity<List<Folder>>(foundFolder, HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity GetFolder(@PathVariable Long id){
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }
}
