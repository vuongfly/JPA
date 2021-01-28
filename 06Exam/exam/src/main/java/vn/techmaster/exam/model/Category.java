package vn.techmaster.exam.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="category")
@Table(name="category")
@Data
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  @OneToMany(
    cascade = CascadeType.ALL,
    orphanRemoval = false,
    fetch = FetchType.LAZY
  )
  @JoinColumn(name = "category_id")
  private List<Product> products = new ArrayList<>();
  public void addProduct(Product product) {
    product.setCategory(this);
    this.products.add(product);
  }
  public void removeProduct(Product product) {
    product.setCategory(null);
    this.products.remove(product);
  }
  
}
