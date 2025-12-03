CREATE DATABASE cupons;
 USE cupons;
 CREATE TABLE associado (
 cpf_associado VARCHAR(11) PRIMARY KEY,
 nom_associado VARCHAR(40),
 dtn_associado DATE,
 end_associado VARCHAR(40),
 bai_associado VARCHAR(30),
 cep_associado VARCHAR(8),
 cid_associado VARCHAR(40),
 uf_associado CHAR(2),
 cel_associado VARCHAR(15),
 email_associado VARCHAR(50),
 sen_associado VARCHAR(20)
 );
 
 CREATE TABLE categoria(
 id_categoria INT PRIMARY KEY,
 nom_categoria VARCHAR(25)
 );
 
 CREATE TABLE comercio(
 cnpj_comercio VARCHAR(14) PRIMARY KEY,
 id_categoria INT,
 raz_social_comercio VARCHAR(50),
 nom_fantasia_comercio VARCHAR(30),
 end_comercio VARCHAR(40),
 bai_comercio VARCHAR(30),
 cep_comercio VARCHAR(8),
 cid_comercio VARCHAR(40),
 uf_comercio CHAR(2),
 con_comercio VARCHAR(15),
 email_comercio VARCHAR(50),
 sen_comercio VARCHAR(20),
 FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
 INDEX COMERCIO_FKIndex1 (id_categoria)
 );
 
 CREATE TABLE cupom (
 num_cupom CHAR(12) PRIMARY KEY,
 cnpj_comercio VARCHAR(14),
 tit_cupom VARCHAR(25),
 dta_emissao_cupom DATE,
 dta_inicio_cupom DATE,
 dta_termino_cupom DATE,
 per_desc_cupom NUMERIC(5,2),
 qnt_cupom INT,
 FOREIGN KEY (cnpj_comercio) REFERENCES comercio(cnpj_comercio),
 INDEX CUPOM_FKIndex1 (cnpj_comercio)
 );
 
CREATE TABLE cupom_associado(
id_cupom_associado INT PRIMARY KEY,
num_cupom CHAR(12),
cpf_associado VARCHAR(11),
dta_cupom_associado DATE,
FOREIGN KEY (num_cupom) REFERENCES cupom(num_cupom),
FOREIGN KEY (cpf_associado) REFERENCES associado(cpf_associado),
INDEX CUPOM_ASSOCIADO_FKIndex1 (num_cupom)
);

INSERT INTO categoria (id_categoria, nom_categoria) VALUES
(1, 'Alimentação'),
(2, 'Supermercado'),
(3, 'Saúde e Beleza'),
(4, 'Moda e Vestuário'),
(5, 'Serviços'),
(6, 'Educação'),
(7, 'Tecnologia'),
(8, 'Lazer e Entretenimento'),
(9, 'Transporte'),
(10, 'Pet Shop');
