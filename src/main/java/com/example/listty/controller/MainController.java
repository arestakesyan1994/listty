package com.example.listty.controller;

import com.example.listty.model.Comment;
import com.example.listty.model.User;
import com.example.listty.model.UserType;
import com.example.listty.repository.*;
import com.example.listty.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ListRepository listRepository;

    @GetMapping("/404-page")
    public String page(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "404-page";
    }

    @GetMapping("/all-business")
    public String allBusiness(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "all-business";
    }

    @GetMapping("/blog")
    public String blog(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "blog";
    }

    @GetMapping("/blog-details")
    public String blogDetails(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "blog-details";
    }

    @GetMapping("/booking-list")
    public String bookingList(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allList", listRepository.findAll());
        return "booking-list";
    }

    @GetMapping("/category-grid")
    public String categoryGrid(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("AllLists", listRepository.findAll());
        return "category-grid";
    }

    @GetMapping("/category-grid-full")
    public String categoryGridFull(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("AllListts", listRepository.findAll());
        return "category-grid-full";
    }

    @GetMapping("/category-grid-right")
    public String categoryGridRight(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("AllListis", listRepository.findAll());
        return "category-grid-right";
    }

    @GetMapping("/category-list-full")
    public String categoryListFull(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("Listts", listRepository.findAll());
        return "category-list-full";
    }

    @GetMapping("/category-list-left")
    public String categoryListLeft(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("Lists", listRepository.findAll());
        return "category-list-left";
    }

    @GetMapping("/category-list-right")
    public String categoryListRight(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allLists", listRepository.findAll());
        return "category-list-right";
    }

    @GetMapping("/comming-soon")
    public String comingSoon(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "comming-soon";
    }

    @GetMapping("/contact-us")
    public String contactUs(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allSubjects", subjectRepository.findAll());
        return "contact-us";
    }

    @GetMapping("/dashboard")
    public String dashboard(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "dashboard";
    }

    @GetMapping("/dashboard-reviews")
    public String dashboardReviews(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "dashboard-reviews";
    }

    @GetMapping("/edit-listings")
    public String editListings(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allCategoreis", categoryRepository.findAll());
        return "edit-listings";
    }

    @GetMapping("/how-it-works")
    public String howItWorks(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "how-it-works";
    }

    @GetMapping("/")
    public String index(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allCategorys", categoryRepository.findAll());
        map.addAttribute("allListts", listRepository.findAll());
        return "index";
    }

    @GetMapping("/index-2")
    public String index2(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allLists", listRepository.findAll());
        return "index-2";
    }

    @GetMapping("/index-3")
    public String index3(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allCategoryis", categoryRepository.findAll());
        return "index-3";
    }

    @GetMapping("/index-4")
    public String index4(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "index-4";
    }

    @GetMapping("/listing-details-left")
    public String listingDetailsLeft(ModelMap map,
                                     @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("allComment", commentRepository.findAll());
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("comments", new Comment());
        return "listing-details-left";
    }

    @GetMapping("/listing-details-full")
    public String listingDetailsFull(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allComment", commentRepository.findAll());
        map.addAttribute("commentss", new Comment());
        return "listing-details-full";
    }

    @GetMapping("/listing-details-right")
    public String listingDetailsRight(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allComment", commentRepository.findAll());
        map.addAttribute("commentsis", new Comment());
        return "listing-details-right";
    }

    @GetMapping("/listings")
    public String listings(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "listings";
    }

    @GetMapping("/listing-sidebar-map-full")
    public String listingSidebarMapFull(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("AllListss", listRepository.findAll());
        map.addAttribute("allCategoriss", categoryRepository.findAll());
        return "listing-sidebar-map-full";
    }

    @GetMapping("/listing-sidebar-map-right")
    public String listingSidebarMapRight(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("AllListsis", listRepository.findAll());
        map.addAttribute("AllCategoris", categoryRepository.findAll());
        return "listing-sidebar-map-right";
    }


    @GetMapping("/listing-sidebar-map-left")
    public String listingSidebarMapLeft(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allCategoris", categoryRepository.findAll());
        map.addAttribute("AllListsiss", listRepository.findAll());
        return "listing-sidebar-map-left";
    }

    @GetMapping("/login")
    public String login(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("allUser", new User());
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal UserDetails userDetails) {
        CurrentUser currentUser = (CurrentUser) userDetails;
        if (currentUser != null) {
            if (currentUser.getUser().getType() == UserType.ADMIN) {
                return "redirect:/profile-admin";
            } else if (currentUser.getUser().getType() == UserType.USER) {
                return "redirect:/user-profile";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/profile-admin")
    public String profileAdmin(ModelMap map, @AuthenticationPrincipal CurrentUser currentUser) {
        map.addAttribute("isLoggedIn", currentUser != null);
        map.addAttribute("user", currentUser.getUser());
        return "profile-admin";
    }

    @GetMapping("/user-profile")
    public String userProfile(ModelMap map, @AuthenticationPrincipal CurrentUser currentUser) {
        map.addAttribute("allComment", commentRepository.findAll());
        map.addAttribute("isLoggedIn", currentUser != null);
        map.addAttribute("comment", new Comment());
        map.addAttribute("user", currentUser.getUser());
        return "user-profile";
    }

    @GetMapping("/oders")
    public String oders(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "oders";
    }

    @GetMapping("/payment-process")
    public String paymentProcess(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "payment-process";
    }

    @GetMapping("/pricing-table")
    public String pricingTable(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "pricing-table";
    }

    @GetMapping("/sign-up")
    public String signUp(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        map.addAttribute("users", new User());
        return "sign-up";
    }

    @GetMapping("/terms-of-services")
    public String termsOfServices(ModelMap map, @AuthenticationPrincipal UserDetails userDetails) {
        map.addAttribute("isLoggedIn", userDetails != null);
        return "terms-of-services";
    }
}