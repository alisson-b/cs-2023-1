# Tarefa 016 - Expressões Regulares - 28/06/2023

1. Elaborar expressões regulares para validação dos objetos constantes da tabela a seguir:

|objeto|formato|Observação|                                                                                           --> ^(\d{6})[-.\/](\d{7})[-.\/](\d{10})[-.\/]
|--|--|--|                                                                                                            -->                  
|Data|dd/mm/aa|as "//" (barras) devem fazer parte da regex|                                                           --> ^([1-9]|0[1-9]|[1,2][0-9]|3[0,1])/([1-9]|1[0,1,2])/\d{2}$
|Data|dd/mm/aaa|as "//" (barras) devem fazer parte da regex|                                                          --> ^([1-9]|0[1-9]|[1,2][0-9]|3[0,1])/([1-9]|1[0,1,2])/\d{3}$
Data|dd/mm/aaa hh:mm:ss|as "//" (barras), os ":" dois pontos e o espaço devem fazer parte da regex|                   --> ^([1-9]|0[1-9]|[1,2][0-9]|3[0,1])/([1-9]|1[0,1,2])/\d{4}$
|Data|yy/mm/dd|as "//" (barras) devem fazer parte da regex|
|Data|yyyy/mm/dd|as "//" (barras) devem fazer parte da regex|
|Número decimal|dd.ddd.ddd|Os "." (pontos ) devem fazer parte da regex. Tanto a parte inteira, como a fracionária podem conter de 1 a 5 casas|
|Nomes de Arquivos / documentos|nome.(doc,docx,xls,xlsx,pdf,csv,txt)|pode utilizar outras extensões para teste.| --> 	^[a-zA-Z0-9-_\.]+\.(pdf|txt|doc|csv)$
|E-mail|nome@dominio|dominio pode ser ".com", ".com.br", ".goias.gov.br", "(.mil, .gov, .esp, .edu).(br,ar,uk,fr,ru,es,it)" --> ^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$
|Codigo Cor HTML ||#00ccff|
|Arquivo de Imagem||*.(jpg,gif,png), etc.|                                                                            --> ^[a-zA-Z0-9-_\.]+\.(jpg|gif|png)$
|Endereco IP ||192.168.1.1| -> 192.168.0.1
|Arquivos Multimedia ||*.(swf,mov,wma,mpg,mp3,wav)|
|Telefone (BR) ||(11) 5555-1977 |                                                                                    -->  ^\(?\d{2}\)?[\s-]?\d{4}-?\d{4}$
|Celular (BR)|(55) (62) 9834.1243|os parênteses e pontos fazem parte da regex.|
|Hora|(HH:MM)|Os ":" dois pontos, fazem parte da regex.|
|Hora|(HH:MM:SS)|Os ":" dois pontos, fazem parte da regex.|
|URL||http://www.google.com, https://www.google.com.br |                                                             -->^(http[s]?://|ftp://)?(www\.)?[a-zA-Z0-9-\.]+\.(com|org|net|mil|edu|ca|co.uk|com.au|gov|br)$
|Domínio||www.yahoo.com, www.yahoo.com.br|                                                                           -->(\W|^)[\w.\-]{0,25}@(yahoo)\.com(\W|)    (\W|^)[\w.\-]{0,25}@(yahoo)\.com(\W|)\.br(\W|$)
|Telefone Internacional |1.245.532.3422|os "." pontos fazem parte da regex.| -                                       --> ^(([0-9]{1})*[- .(]*([0-9a-zA-Z]{3})*[- .)]*[0-9a-zA-Z]{3}[- .]*[0-9a-zA-Z]{4})+$




**INSTRUÇÕES**
1. Esta é uma tarefa para ser elaborada individualmente, embora possa ser discutida com seu colega do lado.
2. Testar se suas regex estão funcionando. Sugestão de site para teste: [regex101](regex101.com)
3. Commitar este arquivo em uma pasta chamada **Tarefa016**, no seu repositório pessoal.
4. O prazo para entrega desta tarefa é as 20h20min do dia 28/06/2023.
