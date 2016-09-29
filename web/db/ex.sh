psql -U horomgr horo_dev < rollback_ddl.sql
psql -U horomgr horo_dev < create_tables_ddl.sql
psql -U horomgr horo_dev < insert_tables_dml.sql
