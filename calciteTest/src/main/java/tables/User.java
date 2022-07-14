package tables;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    Integer id;
    String name;
    String address;
    String phone;
    String remark;
}
