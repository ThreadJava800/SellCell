package com.example.taketook.controllers;

import com.example.taketook.entity.*;
import com.example.taketook.payload.request.ListingController.CreateCommentRequest;
import com.example.taketook.payload.request.ListingController.CreateListingRequest;
import com.example.taketook.payload.response.MessageResponse;
import com.example.taketook.repository.AutomateRepository;
import com.example.taketook.repository.CommentRepository;
import com.example.taketook.repository.ListingRepository;
import com.example.taketook.repository.UserRepository;
import com.example.taketook.service.FileStorageService;
import com.example.taketook.utils.Category;
import com.example.taketook.utils.Constants;
import com.example.taketook.utils.JwtUtils;
import com.example.taketook.utils.ListingDeliveryStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

import static com.example.taketook.utils.Support.getExtensionFromFile;

@RestController
@RequestMapping("/listing")
public class ListingController {
    private final ListingRepository listingRepository;
    private final FileStorageService fileStorageService;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    private final AutomateRepository automateRepository;

    public ListingController(ListingRepository listingRepository, FileStorageService fileStorageService, CommentRepository commentRepository, UserRepository userRepository, JwtUtils jwtUtils, AutomateRepository automateRepository) {
        this.listingRepository = listingRepository;
        this.fileStorageService = fileStorageService;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.automateRepository = automateRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createListing(@RequestHeader("jwt") String jwt, @RequestPart CreateListingRequest createListingRequest, @RequestParam(value = "files", required = false) MultipartFile[] files) {
        String phone = jwtUtils.getIdFromToken(jwt);
        Integer id = 0;

        if (!userRepository.existsByPhone(phone)) {
            id = userRepository.findByPhone(phone).orElseThrow(RuntimeException::new).getId();
            return ResponseEntity.badRequest().body(new MessageResponse("User doesnt exist"));
        }

        Set<Automate> automates = new HashSet<Automate>();

        for (Integer listId : createListingRequest.getAutomateIds()) {
            Automate automate = automateRepository.findById(listId).orElseThrow(RuntimeException::new);
            automates.add(automate);
        }

        Set<ListingDeliveryStatusForListing> delStatuses = new HashSet<>();

        for (ListingDeliveryStatus listId : createListingRequest.getDeliveryStatuses()) {
            ListingDeliveryStatusForListing listingDeliveryStatus = new ListingDeliveryStatusForListing(listId);
            delStatuses.add(listingDeliveryStatus);
        }

        Listing listing = new Listing(createListingRequest.getTitle(), createListingRequest.getDescription(), id, createListingRequest.getDot(), createListingRequest.getActive(), createListingRequest.getCategory(), new HashSet<>(), new HashSet<>(), automates, delStatuses);
        Listing saved = listingRepository.save(listing);

        if (files.length != 0) {
            Set<ImageUrlForListing> imageUrls = new HashSet<>();
            for (int i = 0; i < files.length; i++) {
                String fileName = saved.getId() + "_" + i + "." + getExtensionFromFile(files[i]);
                String imageUrl = uploadFile(Constants.LISTING_IMAGE_FOLDER, files[i], fileName);
                ImageUrlForListing imageUrlForListing = new ImageUrlForListing(imageUrl);
                imageUrls.add(imageUrlForListing);
            }
            saved.setImageUrls(imageUrls);
            saved = listingRepository.save(saved);
        }
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/comment")
    public ResponseEntity<?> leaveComment(@RequestHeader("jwt") String jwt, @RequestBody CreateCommentRequest createCommentRequest) {
        Integer id = Integer.parseInt(jwtUtils.getIdFromToken(jwt));

        if (!userRepository.existsById(id)) {
            return ResponseEntity.badRequest().body(new MessageResponse("User doesnt exist"));
        }

        Listing listing = listingRepository.findById(createCommentRequest.getListingId()).orElseThrow(RuntimeException::new);
        Comment comment = new Comment(createCommentRequest.getText(), id, System.currentTimeMillis());
        Comment newCommentId = commentRepository.save(comment);
        Set<Comment> commentIds = listing.getCommentIds();

        commentIds.add(newCommentId);
        listing.setCommentIds(commentIds);

        return ResponseEntity.ok(listingRepository.save(listing));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllListings() {
        return ResponseEntity.ok(listingRepository.findAll());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getListingsByCategory(@PathVariable Category category) {
        return ResponseEntity.ok(listingRepository.findByCategory(category));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<?> getListingsByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(listingRepository.findByAuthor(author));
    }

    public String uploadFile(Path path, MultipartFile file, String fileName) {
        try {
            fileStorageService.save(file, path, fileName);
            return Constants.SITE_URI + Constants.GET_FILE_SUB_URL + "listings/" + fileName;
        } catch (Exception e) {
            return null;
        }
    }
}
