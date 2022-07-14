package schema;

import tables.User;

public class TestSchema extends Schema {
    public TestSchema() {
        super("test");
    }

    public final User[] users = new User[]{User.builder().id(1).name("A").build()};
}
