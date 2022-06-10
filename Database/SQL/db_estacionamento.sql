#drop database db_estacionamento;
create database db_estacionamento;
use db_estacionamento;

create table tb_funcionario(
		cd_funcionario int not null auto_increment,
		nm_funcionario varchar(100),
        nm_turno varchar(20),
        nm_adm boolean,
        nm_usuario varchar(50),
        cd_senha varchar(50),
		constraint pk_funcionario primary key (cd_funcionario)
		);

create table tb_vaga(
		cd_vaga int not null auto_increment,
		nm_tipo varchar(20),
        nm_estado boolean,
		constraint pk_vaga primary key (cd_vaga)
		);

create table tb_cliente(
		cd_cliente int not null auto_increment,
		nm_cliente varchar(100),
		cd_cpf char(11),
		cd_telefone varchar(14),
		constraint pk_cliente primary key (cd_cliente)
		);
        
create table tb_veiculo(
		cd_veiculo int not null auto_increment,
		cd_placa char(7),
		cd_cliente int,
		constraint pk_veiculo primary key (cd_veiculo),
		constraint fk_veiculo_cliente foreign key (cd_cliente) references tb_cliente(cd_cliente)
		);
        
 create table tb_veiculo_vaga(
		cd_locacao int not null auto_increment,
		dt_entrada datetime,
		dt_saida datetime,
        vl_locacao decimal(9,2),
        cd_veiculo int,
        cd_vaga int,
		constraint cd_locacao primary key (cd_locacao),
		constraint fk_veiculo_vaga_veiculo foreign key (cd_veiculo) references tb_veiculo(cd_veiculo),
        constraint fk_veiculo_vaga_vaga foreign key (cd_vaga) references tb_vaga(cd_vaga)
		);       
        
-- - - - - - Incerts First: - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	
    -- Funcionario: -----------------------------------------------------------------------------
    insert into tb_funcionario(cd_funcionario, nm_funcionario, nm_turno, nm_adm, nm_usuario, cd_senha) values(1,'Funcionario Teste', 'Matutino', true, 'funcTeste', '123');
    
	-- Vagas: -----------------------------------------------------------------------------
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(1,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(2,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(3,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(4,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(5,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(6,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(7,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(8,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(9,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(10,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(11,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(12,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(13,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(14,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(15,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(16,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(17,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(18,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(19,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(20,'Carro', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(21,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(22,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(23,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(24,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(25,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(26,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(27,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(28,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(29,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(30,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(31,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(32,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(33,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(34,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(35,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(36,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(37,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(38,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(39,'Moto', true);
    insert into tb_vaga(cd_vaga, nm_tipo, nm_estado) values(40,'Moto', true);