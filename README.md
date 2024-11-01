# 🚀 Sistema Java Integrado com a API da NASA 🌌


Bem-vindo ao meu projeto mais recente! Este sistema Java inovador integra-se à API da NASA, proporcionando uma experiência interativa para explorar o fascinante mundo das viagens espaciais. 

## 🌟 Principais Funcionalidades

- **Integração com a API da NASA**  
  O sistema consome dados da API da NASA, trazendo informações atualizadas sobre missões espaciais, imagens deslumbrantes e muito mais.

- **Documentação com Swagger**  
  Para facilitar a interação com a API, implementei o Swagger. Esta ferramenta fornece uma interface intuitiva para visualizar e testar os endpoints disponíveis.

- **Front-end Interativo**  
  O sistema possui um front-end dinâmico que exibe um histórico de viagens espaciais. Os usuários podem explorar detalhes de cada missão e visualizar imagens relacionadas, tornando a experiência ainda mais rica e envolvente.

## 🛠️ Desafio Enfrentado: Bug na Porta 8080

Durante o desenvolvimento, enfrentei um desafio ao tentar iniciar a aplicação. A porta 8080, padrão para aplicações Spring Boot, estava em uso por outro processo, impedindo a inicialização da minha aplicação.

### 🔧 Solução Implementada

1. **Identificação do Processo**  
   Usei o comando `netstat -ano | findstr :8080` no terminal para identificar o processo que estava utilizando a porta 8080. Isso me forneceu o ID do processo (PID) em conflito.

2. **Finalização do Processo**  
   Com o PID em mãos, finalizei o processo com o comando `taskkill /PID <PID> /F`, liberando a porta para que minha aplicação pudesse ser iniciada.

3. **Reinício da Aplicação**  
   Após liberar a porta, reiniciei a aplicação com o comando `./mvnw spring-boot:run`, e, felizmente, tudo funcionou perfeitamente!

## 🚀 Conclusão

Esse projeto não só aprimorou minhas habilidades em Java e Spring Boot, mas também me ensinou a importância da gestão de processos e da resolução de problemas em tempo real. Estou ansioso para continuar explorando novas tecnologias e desafios no desenvolvimento de software!

Se você estiver interessado em saber mais sobre o projeto ou discutir sobre desenvolvimento de software, sinta-se à vontade para entrar em contato! 🤝
