package com.bt.assetmgmt.model;


import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "itemId")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item implements Serializable, Comparable<Item> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;

  //  @NotNull(message = "Item name cannot be blank")
//    @Column(name = "item_name", nullable = false)
    private String itemName;

  //  @Range(min = 20_000, max = 50_000)
   // @NotNull(message = "price cannot be empty")
    private double price;

   // @NotBlank(message = "Item description cannot be blank")
    private String description;

   /* public Item(){

    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemId == item.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }*/

    @Override
    public int compareTo(Item item) {
        return (int) (this.itemId - item.itemId);
    }
}