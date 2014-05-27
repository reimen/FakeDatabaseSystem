package org.reimen2422.mvc.models.database.table.usertype;

import org.reimen2422.mvc.models.database.Database;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild;
import org.reimen2422.mvc.models.database.schemamodels.usertype.UserChild$;

public class UserChildTable extends UserTypeTable<UserChild> {

    public UserChildTable(Database database) {
        super(database, UserChild$.getInstance());
    }

}
