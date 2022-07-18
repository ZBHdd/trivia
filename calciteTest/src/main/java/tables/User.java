package tables;

import lombok.Builder;
import lombok.Data;

/**
 * @author hang.jia
 */
@Data
@Builder
public class User {
    public final Integer id;
    public final String name;
    public final String address;
    public final String phone;
    public final String remark;
}
