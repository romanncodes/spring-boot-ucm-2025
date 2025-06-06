package cl.ucm.serviceproduct.dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ProductDtoOut {
    private int id;
    private String name;
    private int price;
    private String category;
}
