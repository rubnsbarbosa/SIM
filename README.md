## Instituto Federal do Ceará
Engenharia de Computação  
Programação Paralela e Distribuída  
2018.2  
Prof. Cidcley T. de Souza  

### Projeto de Espaço de Tuplas
Implementar um Sistema de Interação Móvel (SIM) no qual um usuário deve utilizar para entrar em contato com usuários que estejam a um determinado raio de alcance do seu dispositivo. Ao logar no SIM, o usuário deve fornecer um usuário e senha (se não houver o mesmo deve cadastrar). Conectado, o usuário pode realizar as seguintes ações:  

1) Ligar o Radar: ao pressionar o botão para ligar o Radar, o usuário deve ter fornecido uma distância pela qual o radar irá listar os usuários do sistema que estão logados no momento. Essa distância deve variar entre 300m e 20km, sendo 1km o valor default. Caso a localização física do cliente mude
mais de 300m, ele deve atualizar sua localização junto ao servidor SIM.  
2) Entrar em uma Sala de bate papo e conversar com os usuários que estão logados na sala.  
3) Criar/Apagar uma Sala  

### Atenção:  
* Quando um usuário entra no SIM ele é inscrito em um Espaço de Tuplas, usando um nick e suas coordenadas físicas.  
* Quando o Radar é ligado, o Espaço de Tuplas deve ser consultado para localizar os Usuários que tenham distâncias compatíveis.

### Critérios de Avaliação
Interface do Sistema (0-10);  
Implementação de Funcionalidades (0-10);  

**Trabalho Individual**  
**Data de Entrega:** 12/11 (nota cheia)  
Entrega até 14/11 (-2 pontos)  
Depois disso o trabalho será desconsiderado.  

### Observações:  
1. **TODOS** os trabalhos só serão aceitos se apresentados **pessoalmente** pelo aluno na sala de aula na data final de entrega ou, em casos excecionais, a combinar com o professor.  
2. **TODOS** os trabalhos só serão recebidos através do link até às 12h da data de entrega.  
3. Não serão aceitos trabalhos enviados de qualquer outra forma.  
4. Devem ser entregues **TODOS** os códigos.  
5. Deverá ser entregue, se a linguagem de programação permitir, um código executável (.jar, .exe, etc).  

### Comandos via terminal
> **Terminal - Start Apache River**  
> rubnsbarbosa$ sh start-services.sh  
