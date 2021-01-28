package vn.techmaster.exam.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

@Entity(name="tag")
@Table(name="tag")
@Data
public class Tag {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  @ManyToMany
  @JoinTable(name="products",
  joinColumns = @JoinColumn(name="tag_id"))
  private Set<Product> products;
  
  @OneToMany(mappedBy = "tag")
  Set<ProductTag> setProductTags;
}
