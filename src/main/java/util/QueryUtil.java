package util;

public class QueryUtil {
    public static final String FIND_ALL_QUERY_TEMPLATE = "select * from %s";
    public static final String FIND_BY_ID_QUERY_TEMPLATE = "select * from %s where id = ?";
    public static final String FIND_BY_USERNAME_PASSWORD_QUERY_TEMPLATE = "select * from %s where username = ? and password=?";
    public static final String FIND_BY_CUSTOMER_ID_QUERY_TEMPLATE = "select * from %s where customer_id = ? ";
    public static final String FIND_BY_USERNAME_QUERY_TEMPLATE = "select * from %s where username = ?";
    public static final String DELETE_BY_ID_QUERY_TEMPLATE = "delete from %s where id = ?";
    public static final String EXISTS_BY_ID_QUERY_TEMPLATE = "select count(*) from %s where id = ?";
    public static final String EXISTS_BY_CART_ID_PRODUCT_ID_QUERY_TEMPLATE = "select * from %s where cart_id = ? and product_id=?";
    public static final String EXISTS_BY_NAME_QUERY_TEMPLATE = "select count(*) from %s where username = ?";
    public static final String INSERT_INTO_QUERY_TEMPLATE="insert into %s(%s) values(%s)";
}
