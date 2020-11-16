# trick: Wildcard mechanism sql templating with java
https://stackoverflow.com/questions/3655424/string-replacement-in-java-similar-to-a-velocity-template

```sql
select * from items where description_name like 'Wi%s';
```

```sql
select * from {0} where {1} like '{2}'; 
```

where the {*} will be substituted by a program value, replacing ? to %

using this pattern:

```java
    public void selectWithWildCard(String table, String column,String strWithWildcard){
        Object[] params = new Object[]{table, column, "'"+strWithWildcard+"'"};
        String msg = MessageFormat.format("select * from {0} where {1} like {2};", params);
        System.out.print(msg);
    }
```
template rendered
```sql
select * from tableName where columnName like 'Gor%';
```