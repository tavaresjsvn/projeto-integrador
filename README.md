# Atividade em Grupo - Projeto Integrador II

### Faculdade Alpha
### Professor: Rafael Marinho dos Anjos

### Equipe:

| Alunos |
|--------|
| Ívia Xavier Bezerra |
| Josevan Tavares Pereira Ramos |
| Maria Eduarda Silva de Almeida |
| Saulo Torres de Oliveira Assis |

## Introdução

#### Minimundo ####

#### Descrição do Mundo Real ####

As pessoas que procuram por cuidados capilares, como hidratações, cortes, colorações e tratamentos específicos, enfrentam dificuldades para encontrar salões de beleza e profissionais qualificados que entendam as particularidades do seu tipo de cabelo, principalmente cabelos cacheados, crespos ou quimicamente tratados.
Esses clientes precisam de profissionais especializados, capazes de indicar os melhores tratamentos de acordo com o estado atual do cabelo e os objetivos pessoais de cada um. Contudo, essa busca geralmente é feita de forma aleatória, por indicações de conhecidos ou redes sociais, sem garantia de qualidade ou personalização.
Os salões de beleza, por sua vez, possuem diferentes especializações, e alguns profissionais são mais habilitados para determinados serviços. No entanto, muitas vezes os salões não conseguem atingir o público certo, que busca exatamente os serviços que eles oferecem.
Além disso, clientes têm dificuldade de manter uma rotina de cuidados adequada aos seus cabelos por falta de acompanhamento ou informações corretas, e acabam se esquecendo dos tratamentos necessários ou os realizando de forma incorreta.

#### Descrição de Aplicação ####

O HairMatch é um aplicativo móvel com o objetivo de conectar clientes e salões de forma personalizada e funcional, proporcionando uma experiência completa de cuidados capilares.
Ao baixar o APP o usuário cria um perfil  com informações pessoais, além de detalhar as características do tipo do cabelo e objetivos de tratamento resultando no perfil capilar de cada usuário. Com base nessas informações, o aplicativo oferece recomendações personalizadas de salões e profissionais especializados próximos à sua localização.
O usuário pode selecionar o tipo de serviço, localização e avaliação de outros clientes. Após escolher o salão, é possível visualizar serviços, profissionais e disponibilidade para realizar o agendamento online dentro do aplicativo.
O app também possui uma lista de salões com  melhores posições, alimentado pelas avaliações dos usuários, garantindo maior segurança na hora da escolha.
Somado aos agendamentos, o HairMatch oferece um cronograma de cuidados capilares personalizado, com lembretes e recomendações de produtos e técnicas, ajudando o usuário a manter uma rotina saudável para seus fios.
Existe também uma  opção de assinatura premium, que libera funcionalidades extras como promoções exclusivas e agendamentos prioritários.
Por fim, o aplicativo dispõe de um suporte técnico via chat, garantindo o acompanhamento durante toda a jornada do usuário na plataforma.


## Banco de dados

- [Código de criação do BD](./data/codigo_criacao_banco.sql)

Colocar todas as tabelas do banco no seguinte padrão:

- Usuário:

| Coluna | Tipo | Descrição |
|--------|------|-----------|
| ID_Usuario (PK) | int | Identificador único do usuário |
| Nome | varchar | Nome do usuário  |
| Email | varchar | Email do usuário |
| CPF | varchar | CPF único do usuário |
| Telefone | varchar | Telefone do usuário |
| Idade | int | Idade do usuário |
| Endereço | text | Endereço do usuário |
| Senha | varchar | Senha podendo conter letras e/ou números |
| Plano | varchar | Plano do usuário (gratuito ou premium ) |


- PERFIL CAPILAR:

| Coluna | Tipo | Descrição |
|---|---|---|
| ID_Perfil_Capilar (PK) | int | Identificador único do perfil capilar |
| ID_Usuario (FK) | int | Identificador do usuário relacionado |
| Tipo_de_Cabelo | varchar | Tipo de cabelo (Liso, Ondulado, Cacheado, Crespo) |
| Descrição_da_Curvatura | varchar | Descrição da curvatura do cabelo |
| Curvatura | varchar | Curvatura do cabelo |
| Estado_do_Cabelo | varchar | Estado do cabelo (Ressecado, Oleoso, Quimicamente Tratado, etc.) |
| Objetivo | varchar | Objetivo de cuidado (Hidratação, Nutrição, Reconstrução, etc.) |


- SALÃO:

| Coluna | Tipo | Descrição |
|---|---|---|
| ID_Salao (PK) | int | Identificador único do salão |
| Nome | varchar | Nome do salão |
| Endereço | varchar | Endereço do salão |
| Telefone | varchar | Telefone do salão |
| Especialidades | text | Especialidades do salão |
| Nota | decimal | Nota do salão (gerada pelas avaliações dos usuários) |


- PROFISSIONAL:

| Coluna | Tipo | Descrição |
|---|---|---|
| ID_Profissional (PK) | int | Identificador único do profissional |
| ID_Salao (FK) | int | Identificador do salão onde o profissional trabalha |
| Nome | varchar | Nome do profissional |
| Especialidade | varchar | Especialidade do profissional |
| Telefone | varchar | Telefone do profissional |


- SERVIÇO:

| Coluna | Tipo | Descrição |
|---|---|---|
| ID_Servico (PK) | int | Identificador único do serviço |
| ID_Salao (FK) | int | Identificador do salão que oferece o serviço |
| ID_Funcionario (FK) | int | Identificador do profissional que realiza o serviço |
| Nome | varchar | Nome do serviço |
| Descrição | text | Descrição do serviço |
| Preço | decimal | Preço do serviço |
| Tipo_Serviço | varchar | Tipo de serviço (Corte, Tratamento, Coloração, etc.) |


- AGENDAMENTO:

| Coluna | Tipo | Descrição |
|---|---|---|
| ID_Agendamento (PK) | int | Identificador único do agendamento |
| ID_Usuario (FK) | int | Identificador do usuário que agendou o serviço |
| ID_Salao (FK) | int | Identificador do salão onde o serviço será realizado |
| ID_Profissional (FK) | int | Identificador do profissional que realizará o serviço |
| ID_Servico (FK) | int | Identificador do serviço agendado |
| Data | date | Data do agendamento |
| Hora | time | Hora do agendamento |
| Status | varchar | Status do agendamento (Agendado, Cancelado, Concluído) |


- AVALIAÇÃO:

| Coluna | Tipo | Descrição |
|---|---|---|
| ID_Avaliacao (PK) | int | Identificador único da avaliação |
| ID_Usuario (FK) | int | Identificador do usuário que fez a avaliação |
| ID_Salao (FK) | int | Identificador do salão avaliado |
| Nota | int | Nota da avaliação (1 a 5) |
| Comentário | text | Comentário da avaliação |
| Data_Avaliação | date | Data da avaliação |


- CRONOGRAMA CAPILAR:

| Coluna | Tipo | Descrição |
|---|---|---|
| ID_Cronograma (PK) | int | Identificador único do cronograma |
| ID_Usuario (FK) | int | Identificador do usuário que segue o cronograma |
| ID_Perfil_Capilar (FK) | int | Identificador do perfil capilar relacionado |
| Data | date | Data do cuidado |
| Meu_Cuidado | text | Descrição do cuidado realizado |
| Produto_Sugerido | varchar | Produto sugerido (se for premium) |
| Recomendações | text | Recomendações dos profissionais |


- PLANO:

| Coluna | Tipo | Descrição |
|---|---|---|
| ID_Plano (PK) | int | Identificador único do plano |
| Tipo | varchar | Tipo do plano (Premium anual, mensal ou Básico) |
| Duração | int | Duração do plano (se for premium) |
| Benefícios | text | Benefícios do plano |
| Valor | decimal | Valor do plano |


