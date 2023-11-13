DROP table IF EXISTS empleado;

create table empleado(
    id int auto_increment,
    nombre varchar(250),
    trabajo ENUM('CARPINTERO', 'ESCULTOR', 'COCINERO'),
    salario int
);

insert into empleado (nombre, trabajo, salario) values('Primer empleado', 'CARPINTERO', 1000);
insert into empleado (nombre, trabajo, salario) values('Segundo empleado', 'ESCULTOR', 2000);
insert into empleado (nombre, trabajo, salario) values('Tercer empleado', 'COCINERO', 3000);
insert into empleado (nombre, trabajo, salario) values('Cuarto empleado', 'ESCULTOR', 2000);
insert into empleado (nombre, trabajo, salario) values('Quinto empleado', 'CARPINTERO', 1000);