
cd C:\Program Files\MySQL\MySQL Server 5.7\bin\

mysql -u root -p123456 <C:\Dev\workspace\office\sql\createSchema.sql 

for %%i in (C:\Dev\workspace\office\sql\master-resource\ddl\Table\*.sql) do (
   echo excute %%i
   mysql -u root -p123456 office < %%i
)

for %%i in (C:\Dev\workspace\office\sql\master-resource\dml\Table\*.sql) do (
   echo excute %%i
   mysql -u root -p123456 office < %%i
)

echo success

pause