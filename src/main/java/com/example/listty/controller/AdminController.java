package com.example.listty.controller;


import com.example.listty.model.*;
import com.example.listty.repository.*;
import com.example.listty.security.CurrentUser;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${image.folder}")
    String imageUploadDir;

    @Value("${image.folder1}")
    String imageUploadDir1;

    @GetMapping("/add-listings")
    public String addListings(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allCategory", categoryRepository.findAll());
        map.addAttribute("allRegions", regionRepository.findAll());
        map.addAttribute("lists", new List());
        return "add-listings";
    }

    @GetMapping("/addCategory")
    public String addCategory(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/addComment")
    public String addComment(@AuthenticationPrincipal CurrentUser currentUser, @PathVariable("id") String id,
                             @ModelAttribute("comment") Comment comment) {
        User user = currentUser.getUser();
        comment.setUser(user);
        commentRepository.save(comment);
        return "redirect:/listing-details-left";
    }

    @PostMapping("/updateAdmin")
    public String update(@AuthenticationPrincipal CurrentUser currentUser,
                         @ModelAttribute("user")  User user,
                              @RequestParam("picture") MultipartFile multipartFile) throws IOException {
        Optional<User> optionalUser = userRepository.findById(currentUser.getUser().getId());
        User user1 = optionalUser.get();
//        User user1 = ((CurrentUser)currentUser).getUser();
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setUsername(user.getUsername());
        user1.setPhone(user.getPhone());
        user1.setEmail(user.getEmail());
        user1.setDescription(user.getDescription());
        user1.setLinkedUrl(user.getLinkedUrl());
        user1.setFacebookUrl(user.getFacebookUrl());
        user1.setTwitterUrl(user.getTwitterUrl());
        user1.setYouTubeUrl(user.getYouTubeUrl());
        String pictureName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        File imageDir = new File(imageUploadDir1);
        if (!imageDir.exists()) {
            imageDir.mkdirs();
        }
        File file = new File(imageUploadDir1 + pictureName);
        multipartFile.transferTo(file);
        user1.setPicUrl(pictureName);
        user1.setPicUrl(user1.getPicUrl());
        user1.setPassword(user1.getPassword());
//        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user1);
        return "redirect:/profile-admin";
    }

    @GetMapping("/addSubject")
    public String addSubject(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("subject", new Category());
        return "addSubject";
    }

    @GetMapping("/addRegion")
    public String addRegion(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("region", new Category());
        return "addRegion";
    }


    @GetMapping("/imageListys")
    public void getImageListty(HttpServletResponse response, @RequestParam("fileName") String fileName) throws IOException {
        InputStream in = new FileInputStream(imageUploadDir + fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

    @GetMapping("/imageUsers")
    public void getImageUsers(HttpServletResponse response, @RequestParam("fileName") String fileName) throws IOException {
        InputStream in = new FileInputStream(imageUploadDir1 + fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

    @PostMapping("/addSubject")
    public String addSubject(@ModelAttribute("subjects") Subject subject) {
        subjectRepository.save(subject);
        return "redirect:/addSubject";
    }

    @PostMapping("/addRegion")
    public String addRegion(@ModelAttribute("region") Region region) {
        regionRepository.save(region);
        return "redirect:/addRegion";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);
        return "redirect:/addCategory";
    }

    @PostMapping("/add-listings")
    public String addLists(@ModelAttribute(name = "product") List list,
                           @RequestParam("picture") MultipartFile multipartFile) throws IOException {
        String pictureName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        File imageDir = new File(imageUploadDir);
        if (!imageDir.exists()) {
            imageDir.mkdirs();
        }
        File file = new File(imageUploadDir + pictureName);
        multipartFile.transferTo(file);
        list.setPicUrl(pictureName);
        listRepository.save(list);
        return "redirect:/add-listings";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user,
                          @RequestParam("picture") MultipartFile multipartFile) throws IOException {
        String pictureName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        File imageDir = new File(imageUploadDir1);
        if (!imageDir.exists()) {
            imageDir.mkdirs();
        }
        File file = new File(imageUploadDir1 + pictureName);
        multipartFile.transferTo(file);
        user.setPicUrl(pictureName);
        user.setType(UserType.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/loginSuccess";
    }
}