package com.example.plants.web;

import com.example.plants.model.DTO.ProductAddDTO;
import com.example.plants.model.service.ProductAddServiceModel;
import com.example.plants.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductAddController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductAddController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
        public String addProduct() {
        return "product-add";
    }

    @ModelAttribute
    public ProductAddDTO productAddDTO() {
        return new ProductAddDTO();
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddDTO productAddDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddDTO", productAddDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddDTO", bindingResult);
            return "redirect:/products/add";
        }

        productService.addOrder(modelMapper
                .map(productAddDTO, ProductAddServiceModel.class));

        return "redirect:/";

    }


}
