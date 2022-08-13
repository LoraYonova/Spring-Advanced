package com.example.plants.web;

import com.example.plants.model.DTO.ProductEditDTO;
import com.example.plants.model.entity.ProductEntity;
import com.example.plants.model.entity.enums.CategoryEnum;
import com.example.plants.model.service.ProductEditServiceModel;
import com.example.plants.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;

        this.modelMapper = modelMapper;
    }


    @GetMapping("/indoor")
    public String productIndoor(Model model) {
        model.addAttribute("products", productService.findAllProductByCategoryEnum(CategoryEnum.INDOOR));
        return "products";
    }


    @GetMapping("/outdoor")
    public String productOutDoor(Model model) {
        model.addAttribute("products", productService.findAllProductByCategoryEnum(CategoryEnum.OUTDOOR));
        return "products";
    }

    @GetMapping("/all")
    public String productsAll(Model model) {
        model.addAttribute("products", productService.findAllPlants());
        return "products";
    }


    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        ProductEntity productEntity = productService.findById(id);

        if(productEntity != null) {
            model.addAttribute("product", productEntity);
        return "details";
        } else {
            return "error/404";
        }
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        ProductEntity productEntity = productService.findById(id);

        if(productEntity != null) {
            productService.delete(id);
            return "redirect:/";
        } else {
            return "error/404";
        }

    }

    @GetMapping("/edit/{id}")
    public String editIndoorProduct(@PathVariable Long id, Model model) {

        ProductEntity productEntity = productService.findById(id);
        ProductEditDTO productEditDTO = modelMapper.map(productEntity, ProductEditDTO.class);

        if (productEntity != null) {
            model.addAttribute("productEditDTO", productEditDTO);
            model.addAttribute("method", "indoor");
            model.addAttribute("method", "outdoor");

            return "product-update";
        } else {
            return "error/404";
        }
    }


     @PostMapping("/edit/{id}")
    public String confirmIndoorEditProduct(@PathVariable Long id,
                                           @Valid ProductEditDTO productEditDTO,
                                           BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productEditDTO", productEditDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productEditDTO", bindingResult);
            model.addAttribute("method", "indoor");
            model.addAttribute("method", "outdoor");
            return "product-update";
        }


        productService.edit(modelMapper.map(productEditDTO, ProductEditServiceModel.class));
        return "redirect:/";

    }






}
