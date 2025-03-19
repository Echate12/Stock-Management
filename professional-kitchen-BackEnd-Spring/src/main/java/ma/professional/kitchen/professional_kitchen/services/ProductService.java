package ma.professional.kitchen.professional_kitchen.services;

import ma.professional.kitchen.professional_kitchen.dto.CategorySummary;
import ma.professional.kitchen.professional_kitchen.entities.ProductEntity;
import ma.professional.kitchen.professional_kitchen.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public ProductEntity updateProduct(Long id, ProductEntity updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }

    public List<CategorySummary> getCategorySummaries() {
        List<ProductEntity> products = productRepository.findAll();

        Map<String, CategorySummary> summaryMap = products.stream().collect(
                Collectors.groupingBy(
                        ProductEntity::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                productList -> {
                                    CategorySummary summary = new CategorySummary();
                                    summary.setCategory(productList.get(0).getCategory());
                                    summary.setTotalProducts(productList.size()); // Number of rows
                                    summary.setTotalQuantity(productList.stream().mapToInt(ProductEntity::getQuantity).sum());
                                    summary.setTotalPurchasePrice(productList.stream().mapToDouble(ProductEntity::getPrixAchat).sum());
                                    summary.setTotalSalePrice(productList.stream().mapToDouble(ProductEntity::getPrixVente).sum());
                                    return summary;
                                }
                        )
                )
        );

        return summaryMap.values().stream().collect(Collectors.toList());
    }
}
