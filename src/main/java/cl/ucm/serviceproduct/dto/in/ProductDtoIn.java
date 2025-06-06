package cl.ucm.serviceproduct.dto.in;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDtoIn {
    private String name;
    private int price;
    private int category;
}
