package com.uuhnaut69.mall.domain.model;

import com.uuhnaut69.mall.core.model.AbstractEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
@Data
@Entity
@Audited
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Product Model", description = "Product's info")
public class Product extends AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Product's id")
    private UUID id;

    @Column(nullable = false)
    @ApiModelProperty(value = "Product's name")
    private String productName;

    @ApiModelProperty(value = "Product's description")
    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Min(0)
    @Column(nullable = false)
    @ApiModelProperty(value = "Product's stock count")
    private Integer stocks = 0;

    @Min(0)
    @ApiModelProperty(value = "Product's sold count")
    private int soldCount;

    @ApiModelProperty(value = "Product's image url")
    private String imageUrls;

    @Column(nullable = false)
    @ApiModelProperty(value = "Product's thumbnail url")
    private String thumbNail;

    @Column(nullable = false)
    @ApiModelProperty(value = "Product's original price")
    private BigDecimal originalPrice;

    @Column
    @ApiModelProperty(value = "Product's discount price")
    private BigDecimal discountPrice;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_tag", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    @ApiModelProperty(value = "Mark product is hot")
    private boolean trending;
}
