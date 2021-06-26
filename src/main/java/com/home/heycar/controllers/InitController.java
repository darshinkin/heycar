package com.home.heycar.controllers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.home.heycar.services.FileSystemStorageService;

@Controller
public class InitController {

    private FileSystemStorageService fileSystemStorageService;

    private InitController(FileSystemStorageService fileSystemStorageService) {
        this.fileSystemStorageService = fileSystemStorageService;
    }

    @GetMapping("/")
    public String listAllFiles(Model model) {

        model.addAttribute("files", fileSystemStorageService.loadAll().map(
                path -> UriComponentsBuilder.fromPath("/download/")
                        .path(path.getFileName().toString())
                        .toUriString())
                .collect(Collectors.toList()));

        return "listFiles";
    }
}
