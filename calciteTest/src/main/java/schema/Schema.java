package schema;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Schema {
    String name;

    public Schema(String name){
        this.name = name;
    }
}
