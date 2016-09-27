psql -U miniboardmgr miniboard < rollback_ddl.sql
psql -U miniboardmgr miniboard < create_tables_ddl.sql
psql -U miniboardmgr miniboard < insert_tables_dml.sql
