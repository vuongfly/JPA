package vn.techmaster.exam.model;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="product")
@Table(name="product")
@Data
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  @ManyToOne(fetch = FetchType.LAZY)
  private Category category;

  @OneToMany(mappedBy = "product")
  Set<ProductTag> setProductTags;
}
