package ma.professional.kitchen.professional_kitchen.controller;

import ma.professional.kitchen.professional_kitchen.dto.CategorySummary;
import ma.professional.kitchen.professional_kitchen.entities.ProductEntity;
import ma.professional.kitchen.professional_kitchen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3002") // Adjust the origin to your frontend's URL if needed
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(required = false) String label) {
        if (label == null || label.isEmpty()) {
            return productService.getAllProducts();
        }
        return productService.getAllProducts().stream()
                .filter(product -> product.getLabel().contains(label))
                .toList();
    }

    @GetMapping("/{id}")
    public ProductEntity getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/category-summaries")
    public List<CategorySummary> getCategorySummaries() {
        return productService.getCategorySummaries();
    }
    
}
