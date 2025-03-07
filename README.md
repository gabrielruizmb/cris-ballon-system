## Sistema da Cris Ballon

Sistema de gerenciamento de produtos, clientes e pedidos do ateliê da Cris Ballon.

## Como contribuir com o código?

1) Dentro de uma pasta em seu computador execute o comando git clone urlDoRepositório.

2) Crie sua branch no Github e uma com o mesmo nome no repositório git do seu pc, com o comando git checkout -b nomedabranch.

3) Antes de codar execute: 
    - git pull origin minhabranch(Isto puxa o conteúdo da sua branch no Github para sua branch local).

4) Ao terminar de codar, use:
    - git add .  
    - git commit -m "Mensagem desejada"  
    - git push origin minhabranch(Isto empurra o conteúdo da sua branch local para sua branch no Github).

## Estrutura das pastas

- `src`: Onde fica o código em java.
- `lib`: Onde fica as dependências(que ainda não usamos).

O código compilado vai para a pasta `bin` isto acontece automaticamente quando clicamos em >Run java.