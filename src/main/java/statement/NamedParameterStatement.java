package statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamedParameterStatement {

    private PreparedStatement statement;
    private Map<String, List<Integer>> indexMap;


    public NamedParameterStatement(Connection connection, String query) throws SQLException {
        indexMap = new HashMap<>();
        statement = connection.prepareStatement(parse(query));
    }

    private String parse(String query) {
        String pattern = "";
        return "";
    }

    public void setInt(String name, int value) throws SQLException{
        for (Integer index : indexMap.get(name)) {
            statement.setInt(index, value);
        }
    }

    public void setString(String name, String value) throws SQLException{
        for (Integer index : indexMap.get(name)) {
            statement.setString(index, value);
        }
    }

    public void close() throws SQLException{
        statement.close();
    }
}
