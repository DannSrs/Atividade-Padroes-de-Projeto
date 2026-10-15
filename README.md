Pergunta: Como a separação entre a estrutura do Composite e a lógica de percurso do Iterator
facilitatou a adição dessa nova regra sem quebrar o código do cliente?

A separação facilitou porque permitiu criar uma nova lógica de busca e filtragem por fora, usando só a interface do Iterator, 
sem precisar alterar ou expor a estrutura interna das classes do Composite (Modulo e Aula). 
Dessa forma, novas regras podem ser adicionadas sem modificar o código existente e sem risco de quebrar o cliente.
