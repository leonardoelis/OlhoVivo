<h1>API Olho Vivo</h1>
Utilização da API Rest Olho Vivo da SPTrans com Java. Essa API possui diversas informações sobre as linhas e ônibus de São Paulo, por exemplo, localização das paradas de uma determinada linha, informações sobre os corredores de ônibus da capital paulista, localização dos veículos de determinada linha, previsão de chegada de veículos em certas paradas, etc. Nesse projeto, o usuário deve informar o número de uma linha de ônibus e o programa mostrará as informações sobre essa linha e sobre os ônibus dessa linha. Para a implementação desse projeto foram usadas algumas bibliotecas e API's:
<ul>
  <li><a href="http://www.sptrans.com.br/desenvolvedores/api-do-olho-vivo-guia-de-referencia/documentacao-api/" target="_blank">API Olho Vivo da SPTrans</a></li>
    <ul>
      <li>Lembrando que essa API necessita de autenticação para ser utilizada, ou seja, é necessário criar uma conta para poder receber um token de acesso e, assim, utilizar esse token no código</li>
      <li><a href="http://www.sptrans.com.br/desenvolvedores/" target="_blank">Link para se cadastrar e utilizar a API</a></li>
    </ul>
  <li><a href="https://hc.apache.org/downloads.cgi" target="_blank">HttpClient</a>, utilizada para fazer as requisições HTTP para a API Olho Vivo. A versão utilizada nesse projeto foi HttpClient 4.5.13</li>
  <li><a href="https://github.com/DeveloperArthur/meu-buscador-de-cep/blob/master/jars/gson-2.8.5.jar?raw=true" target="_blank">GSON</a>, utilizada para converter o arquivo JSON de resposta da API Olho Vivo em objeto Java</li>
</ul>
