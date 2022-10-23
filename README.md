- Veri tabanı oluşturulduktan sonra yeni veri eklemek için:
src/main/java/com/bim423/estufasting/core/repository/initialdataloaders/concretes package'ında yoksa var olan
örneklere bakarak yeni oluşturun varsa olan class'a girerek data Collection'ına yeni entity ekleyerek veritabanı 
oluşturulurken kaydedilmesini sağlayabilirsiniz. Nasıl çalıştığını öğrenmek için iletişime geçiniz :)
###### Not: Yeni oluşturduğunuz InitialDataLoader'ınızın entity tipi için com/bim423/estufasting/core/repository/abstracts'da jpa repository'si olduğundan emin olun

#
#### Database Naming Conventions

- Table prefix -> tb_

- Column prefixes:

  - IDentifier(primary key) column 	-> id_[table-name]
  - ReFerence(foreign key) column 	-> rf_
  - UniQue(unique key) column 		-> uq_
   
  - (text) varchar, char... : tx_
  - (quantity) integer, decimal...	: qt_
  - (date) date, time, datetime... : dt_
  - (is) boolean : is_

- Key naming:
  - Primary key naming: pk_[table_name]_[column_name]
  - Foreign key naming: fk_[table_name]_[column_name]
  - Unique  key naming: uk_[table_name]_[column_name]

###### Note: [table-name] (etc.) means raw name of the table(without prefix)
###### For example: the name of the primary key column name of tb_user table is: id_user(not id_tb_user)

