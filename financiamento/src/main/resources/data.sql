INSERT INTO USUARIO (cpf, nome, password) VALUES ('338.862.900-50' ,'Joao Augusto', '$2a$10$4ynmEV7wYW67tG2rUXXGneMoasrG9UYyGVv4burTA.oDBjOxiAI2O' );
INSERT INTO USUARIO (cpf, nome, password) VALUES ('595.702.290-04' ,'Antonio Bandeiras', '$2a$10$Qoo32/gLx34OhdW5z/mg1uLtvKBPVsWQLWy76EdA8GvD9C6xsfZES' );

INSERT INTO CLIENTE (nome, cpf) VALUES ('Joao Guilherme' , '321.020.070-06');
INSERT INTO CLIENTE (nome, cpf) VALUES ('Antonio Silva' , '481.994.270-00');

INSERT INTO PROPOSTA (taxa_Juros, valor_Financiado, Cliente_id_Cliente, Usuario_id_Usuario) VALUES ('2500','4','2','1');
INSERT INTO PROPOSTA (taxa_Juros, valor_Financiado, Cliente_id_Cliente, Usuario_id_Usuario) VALUES ('1000','3','1','1');
INSERT INTO PROPOSTA (taxa_Juros, valor_Financiado, Cliente_id_Cliente, Usuario_id_Usuario) VALUES ('500','5','2','2');