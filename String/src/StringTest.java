

public class StringTest {
    public static void main(String[] args) {
String searchTitle="W pustyni i w puszczy";
    String sql=
            "SELECT"+
                    "id,title,description"+
                    "FROM"+
                    "books"+
                    "WHERE"+
                    "title='%s";
    sql=sql.formatted(searchTitle);
    String sql2= """
            SELECT
              id,title,description
            FROM
              books
            WHERE
              title='%s'
            """;
    sql2=sql2.formatted(searchTitle);
   sql2= sql2.indent(4);
        System.out.printf(sql2);



    }
}
