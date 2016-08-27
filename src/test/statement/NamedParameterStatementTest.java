package statement;



/**
 * Created by Олег on 16.08.2016.
 */
public class NamedParameterStatementTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void setInt() throws Exception {
        String query = "UPDATE table SET name = :name WHERE id = :id";
//        NamedParameterStatement statement = new NamedParameterStatement(query);
    }

    @Test
    public void setString() throws Exception {

    }

    @Test
    public void close() throws Exception {

    }

}