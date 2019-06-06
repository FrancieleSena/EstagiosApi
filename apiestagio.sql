drop database if exists apiestagio;
create database apiestagio;
use apiestagio;

create table usuario(
id int auto_increment not null,
nome varchar(100),
login varchar(100),
tipo varchar(25),
status char(1),
faculdade int,
empresa int,
senha varchar(100),
token varchar(22) DEFAULT NULL,
chave varchar(22) DEFAULT NULL,
expiracao timestamp NULL DEFAULT NULL,
primary key(id)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

create table faculdade(
id int auto_increment not null,
nome varchar(100),
razao_social varchar(255),
cnpj varchar(14),
telefone varchar(14),
logradouro varchar(50),
uf char(2),
cidade varchar(50),
bairro varchar(25),
status char(1),
numero int,
PRIMARY key(id)
);

create table curso(
id int auto_increment not null,
nome varchar(50),
duracao varchar(25),
faculdade int,
foreign key(faculdade) references faculdade(id),
primary key(id));

create table aluno(
id int auto_increment not null,
nome_completo varchar(255),
matricula int,
dta_nascimento date,
cpf varchar(11),
telefone varchar(14),
email varchar(50),
faculdade int not null,
status char(1),
dta_conclusaoCurso date,
curso int,
foreign key(faculdade) references faculdade(id),
foreign key(curso) references curso(id),
primary key(id)
);

create table empresa(
id int auto_increment not null,
nome varchar(100),
razao_social varchar(255),
cnpj varchar(14),
telefone varchar(14),
logradouro varchar(50),
uf char(2),
cidade varchar(50),
bairro varchar(25),
numero int,
area_atuacao varchar(100),
qtdeFuncionario int,
status char(1),
primary key(id));

create table vaga(
id int auto_increment not null,
descricao text,
local_atuacao varchar(255),
status char(1),
salario double,
horario varchar(15),
empresa int,
beneficios varchar(255),
cargo varchar(50),
qtdeVagas int,
inicioDivulgacao date,
contato varchar(100),
foreign key(empresa) references empresa(id),
primary key(id));

create table divulgacaoVaga(
vaga int,
faculdade int,
curso int,
foreign key(faculdade) references faculdade(id),
foreign key(vaga) references vaga(id),
foreign key(curso) references curso(id)
);

create table candidatos(
id int auto_increment not null,
vaga int,
aluno int,
foreign key(vaga) references vaga(id),
foreign key(aluno) references aluno(id),
primary key(id));